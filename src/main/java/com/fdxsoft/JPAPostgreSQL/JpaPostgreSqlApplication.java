package com.fdxsoft.JPAPostgreSQL;

import com.fdxsoft.JPAPostgreSQL.domain.AddressEntity;
import com.fdxsoft.JPAPostgreSQL.domain.ClientEntity;
import com.fdxsoft.JPAPostgreSQL.domain.CourseEntity;
import com.fdxsoft.JPAPostgreSQL.domain.InscriptionEntity;
import com.fdxsoft.JPAPostgreSQL.domain.OneUseEntity;
import com.fdxsoft.JPAPostgreSQL.domain.ProductEntity;
import com.fdxsoft.JPAPostgreSQL.domain.StudentEntity;
import com.fdxsoft.JPAPostgreSQL.domain.UserEntity;
import com.fdxsoft.JPAPostgreSQL.repository.IAddressRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IClientRepository;
import com.fdxsoft.JPAPostgreSQL.repository.ICourseRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IInscriptionRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IOneUseRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IProductRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IStudentRepository;
import com.fdxsoft.JPAPostgreSQL.repository.IUserRepository;

import java.time.LocalDate;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaPostgreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPostgreSqlApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(
			IUserRepository userRepository,
			IClientRepository clientRepository,
			IAddressRepository addressRepository,
			IProductRepository productRepository,
			IOneUseRepository oneUseRepository, 
			IStudentRepository studentRepository,
			ICourseRepository courseRepository,
			IInscriptionRepository inscriptionRepository
	) {
		return args -> {
			boolean hayDatos=false;
			try {
				hayDatos = oneUseRepository.count()!=0;
			} catch (Exception e) {
				hayDatos=false;
			}
			if(!hayDatos) {
				//Indicamos por primera y unica vez que ya hay datos en la BD
				OneUseEntity oneUseEntity = oneUseRepository.save(new OneUseEntity(null, "YES"));
				//Primeramente creamos la entidad principal
				ClientEntity client1 = clientRepository.save(new ClientEntity(null,"Yolanda","Belmares", null, null));
				//Despues la insertamos en una entidad de su propiedad
				UserEntity user1 = userRepository.save(new UserEntity(null, "yolanda","1234", client1));		
				//Ahora creamos algunas direcciones
				AddressEntity add1 = addressRepository.save(new AddressEntity(null, "FEDERICO", "Pavo", 5509));
				AddressEntity add2 = addressRepository.save(new AddressEntity(null, "YOLANDA", "Grulla", 5537));
				AddressEntity add3 = addressRepository.save(new AddressEntity(null, "MAMA", "Avoceta", 5562));
				//Hasta aqui, solamente ha guardado las direcciones en su tabla, pero no en la tabla de relaciones
				//Y se las agregamos al Cliente
				client1.setAddresses(Set.of(add1,add2,add3));
				//En esta parte creamos los productos
				ProductEntity pr1 = productRepository.save(new ProductEntity(null, "TV Sanmsung FDX2025", 15000));
				ProductEntity pr2 = productRepository.save(new ProductEntity(null, "Nintendo SWITCH 2025", 10000));
				ProductEntity pr3 = productRepository.save(new ProductEntity(null, "MOTO G53 Dual SIM", 3980));
				ProductEntity pr4 = productRepository.save(new ProductEntity(null, "TABLET SONY TB2500", 10500));
				client1.setProducts(Set.of(pr1,pr2,pr3,pr4));
				//ACtualizamos el cliente
				ClientEntity yola = clientRepository.save(client1);
				//Aqui ya guardo la informacion de las relaciones de las direcciones nuevas y el cliente
				//Y finalmente lo mostramos
				System.out.println("User saved: " + yola);
				//Primero creamos un estudiante
				StudentEntity student1 = studentRepository.save(new StudentEntity(null, "Federico", "Martinez",null));
				//Despues creo los cursos que va a llevar
				CourseEntity c1 = courseRepository.save(new CourseEntity(null, "Matematicas I"));
				CourseEntity c2 = courseRepository.save(new CourseEntity(null, "Algebra"));
				CourseEntity c3 = courseRepository.save(new CourseEntity(null, "Geometria Analitica"));
				//Ahora si hacemos las inscripciones del estuduante a cada uno de los cursos
				InscriptionEntity in1 = inscriptionRepository.save(new InscriptionEntity(null, student1, c1, LocalDate.of(2025, 5, 30)));
				InscriptionEntity in2 = inscriptionRepository.save(new InscriptionEntity(null, student1, c2, LocalDate.of(2025, 5, 30)));
				InscriptionEntity in3 = inscriptionRepository.save(new InscriptionEntity(null, student1, c3, LocalDate.of(2025, 5, 30)));
				//Ahora rellenamos el estudiante con sus cursos
				student1.setInscriptions(Set.of(in1,in2,in3));
				//Las guardamos o actualizamos en el estuduante
				StudentEntity studentFederico = studentRepository.save(student1);
				System.out.println("Estudiante: " + studentFederico);
				
			}
		};
	}
}
