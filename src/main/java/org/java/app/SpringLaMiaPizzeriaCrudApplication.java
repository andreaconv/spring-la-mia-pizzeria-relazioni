package org.java.app;

import java.util.Arrays;
import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	    List<Pizza> pizze = Arrays.asList(
	            new Pizza("marinara", "pomodoro, origano, aglio", "marinara", 4.5f),
	            new Pizza("margherita", "pomodoro, mozzarella, basilico", "margherita", 6.5f),
	            new Pizza("wurstel", "pomodoro, mozzarella, wurstel", "wurstel", 5.5f),
	            new Pizza("diavola", "pomodoro, mozzarella, salame piccante", "diavola", 8.5f),
	            new Pizza("prosciutto", "pomodoro, mozzarella, prosciutto cotto", "prosciutto", 6f),
	            new Pizza("napoletana", "pomodoro, mozzarella, acciughe, origano", "napoletana", 5.5f),
	            new Pizza("pugliese", "pomodoro, mozzarella, cipolla", "pugliese", 5.5f),
	            new Pizza("romana", "pomodoro, mozzarella, acciughe, capperi, origano", "romana", 6.5f),
	            new Pizza("prosciutto e funghi", "pomodoro, mozzarella, prosciutto cotto, funghi", "prosc-funghi", 6.5f),
	            new Pizza("quattro stagioni", "pomodoro, mozzarella, prosciutto cotto, funghi, carciofi, olive", "stagioni", 8.5f),
	            new Pizza("parmigiana", "pomodoro, mozzarella, melanzane, grana", "parmigiana", 6f),
	            new Pizza("capricciosa", "pomodoro, mozzarella, carciofi, funghi, olive, capperi, origano, acciughe", "capricciosa", 8f),
	            new Pizza("quattro formaggi", "mozzarella, zola, scamorza, stracciatella di bufala", "formaggi", 8f),
	            new Pizza("speck e zola", "pomodoro, mozzarella, speck, zola", "speck", 7f),
	            new Pizza("estate", "pomodoro, mozzarella, pomodoro fresco, basilico", "estate", 6f),
	            new Pizza("zucchine", "pomodoro, mozzarella, zucchine, grana", "zucchine", 6f),
	            new Pizza("bufalina", "pomodoro, mozzarella bufala campana, basilico", "bufalina", 7f),
	            new Pizza("prosciutto e carciofi", "pomodoro, mozzarella, prosciutto cotto, carciofi", "prosc-carciofi", 6.5f),
	            new Pizza("tonno e cipolla", "pomodoro, mozzarella, tonno, cipolla", "tonno", 6.5f),
	            new Pizza("ortolana", "mozzarella, peperoni, melanzane, zucchine, funghi", "ortolana", 7.5f)
	    );
	    
	    pizze.forEach(pizzaService::save);
	    
	    System.out.println("Insert OK!");
	}
	

}
