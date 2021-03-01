package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;
import model.Cuenta;
@Service
public class CuentasServiceImpl implements CuentasService {
	@PersistenceContext(unitName = "bancaPU")
	EntityManager em;
	@Override
	public List<Cuenta> obtenerCuentasNoCliente(int dni) {
		String jpql="Select c From Cuenta c where c not in ";
		jpql+="(Select distinct c From Cuenta c join c.clientes t Where t.dni=?1)";
		TypedQuery<Cuenta> query=em.createQuery(jpql,Cuenta.class);
		query.setParameter(1, dni);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void actualizarCuenta(int numeroCuenta, int dni) {//este metodo debio llamarse altaCuenta
		Cuenta cuenta=em.find(Cuenta.class, numeroCuenta);
		Cliente cliente=em.find(Cliente.class, dni);
	//	cuenta.getClientes().add(cliente); // no da error pero no funciona
	//	em.merge(cuenta);
		cliente.getCuentas().add(cuenta); // hacer merge en la propietaria
		em.merge(cliente);
     /* asignar una cuenta a cliente , cualquier cambio para llevarlo a bbdd hay que hacer un merge
      * tengo el cliente y su coleccion de cuentas si a la coleccion de cuentas,
      * le añado otra cuenta nueva, y hago el merge del cliente se añade la cuenta a titulares
      * tiene que ser sobre la propiedad de la Entidad donde esta el join table
      */
	}

} 
 