package com.rainbow.mobProgramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobProgrammingApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(MobProgrammingApplication.class, args);
//	}

	public static void main(String[] args) {
		Mob mob = new Mob();
		mob.run();
	}

}
