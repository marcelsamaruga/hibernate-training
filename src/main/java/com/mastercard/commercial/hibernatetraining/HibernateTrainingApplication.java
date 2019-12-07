package com.mastercard.commercial.hibernatetraining;

import com.mastercard.commercial.hibernatetraining.hero.entity.Hero;
import com.mastercard.commercial.hibernatetraining.hero.entity.Mission;
import com.mastercard.commercial.hibernatetraining.hero.entity.Team;
import com.mastercard.commercial.hibernatetraining.hero.entity.User;
import com.mastercard.commercial.hibernatetraining.hero.repository.HeroRepository;
import com.mastercard.commercial.hibernatetraining.hero.repository.MissionRepository;
import com.mastercard.commercial.hibernatetraining.hero.repository.TeamRepository;
import com.mastercard.commercial.hibernatetraining.hero.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HibernateTrainingApplication  implements ApplicationRunner {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private HeroRepository heroRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateTrainingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		// EXERCISE 1
		// create new team


		// *** *** *** ***

		// EXERCISE 2
		// create a hero


		// *** *** *** ***

		// EXERCISE 3
		//  associate hero to team


		// *** *** *** ***

		// EXERCISE 4
		// create new mission

		// associate hero with mission


		// *** *** *** ***

		// EXERCISE 5
		// cascade


		// *** *** *** ***

		// EXERCISE 6
		// fetch type
		// spring.jpa.show-sql=true


		// *** *** *** ***

		// EXERCISE 7
		// HQL

		// find all heroes


		// *** *** *** ***

		// EXERCISE 8
		// find hero by ID

		// *** *** *** ***

		// EXERCISE 9
		// find hero by initial name

		// *** *** *** ***

		// EXERCISE 10
		// get the heroes of an specific mission

		System.exit(0);
	}

}
