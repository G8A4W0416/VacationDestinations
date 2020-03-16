package dmacc;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Trip;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.TripRepository;

@SpringBootApplication
public class VacationDestinationsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VacationDestinationsApplication.class, args);
	}
	
	@Autowired
	TripRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Trip t1 = appContext.getBean("trip", Trip.class);
		t1.setDestination("Philadelphia");
		t1.setTripCost(1000);
		t1.setTripStart(LocalDate.of(2020, 5, 7));
		t1.setTripEnd(LocalDate.of(2020, 5, 12));
		repo.save(t1);
		
		Trip t2 = new Trip("Orlando", 500, LocalDate.of(2020, 12, 20), LocalDate.of(2020, 12, 31));
		repo.save(t2);
		
		Trip t3 = new Trip("Tahiti", 5000, LocalDate.of(2025, 5, 5), LocalDate.of(2025, 5, 19));
		repo.save(t3);
		
		List<Trip> allTrips = repo.findAll();
		for(Trip trip: allTrips) {
			System.out.println(trip.toString());
		}
		
		((AbstractApplicationContext) appContext).close();
	}
}