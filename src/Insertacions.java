
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import Entidades.Alumnos;
import Entidades.Modulos;
import Entidades.Profesores;

public class Insertacions {

	public static void main(String[] args) {

		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class).addAnnotatedClass(Alumnos.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());

			// Crear la factoría de sesiones

			SessionFactory factory = configuration.buildSessionFactory(builder.build());

		//Crear la sesión
				
		Session session = factory.getCurrentSession();

				try {
					
		session.beginTransaction();
			
		Profesores profe1 = new Profesores("Juan Carlos Garcia", "58954664A", "prof1@gmail.com");
		Profesores profe2 = new Profesores("Antonio Garrido", "785231452B", "prof2@truemail.com");
		
		Modulos mod1 = new Modulos("Matematicas", profe1);
		Modulos mod2 = new Modulos("Fisica", profe2);
			
		Alumnos alum1 = new Alumnos("Maria Sanchez", "maria78@gmail.com");
		Alumnos alum2 = new Alumnos("Juan Casado", "alu2@hotmail.com");			
		Alumnos alum3 = new Alumnos("Pedro Lopez", "superpedrito@gmail.com");

		alum1.addModulo(mod1);			
		alum2.addModulo(mod1);				
		alum3.addModulo(mod2);				

		session.save(profe1);
		session.save(profe2);
		session.save(mod1);
		session.save(mod2);
		session.save(alum1);
		session.save(alum2);
		session.save(alum3);
			
		session.getTransaction().commit();
			
				session.close();
				} 
		finally {
					factory.close();
				}
		}
}
	
	
	
	
	

