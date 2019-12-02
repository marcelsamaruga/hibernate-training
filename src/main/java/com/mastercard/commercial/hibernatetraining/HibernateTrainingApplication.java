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
import java.util.Calendar;

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
		Team team = new Team();
		team.setName("Avengers");

		teamRepository.persist(team);
		System.out.println("Id: " + team.getId() + " - Name: " + team.getName());

		// merge team
		team.setName("Justice League");
		teamRepository.merge(team);

		System.out.println(team);

		// ???? merge/persist in one method at repository layer ????

		// *** *** *** ***

		// EXERCISE 2
		// create a hero
		Hero superBoy = new Hero();
		superBoy.setFullName("Super Boy");

		heroRepository.persist(superBoy);

		System.out.println("Hero details: " + superBoy.toString());

		// and now associate with a user
		User user = new User();
		user.setEmail("superboy@justiceleague.com");
		user.setUsername("super_boy");
		user.setPassword("strength");
		user.setRenewAt(DateTime.now().plusMonths(3).toDate());

		user.setHero(superBoy);

		user = userRepository.persist(user);

		System.out.println(user);

		// *** *** *** ***

		// EXERCISE 3

		superBoy.setTeam(team);
		superBoy = heroRepository.merge(superBoy);

		// *** *** *** ***

		// EXERCISE 4
		// create new mission
		Mission missionRescueRobin = new Mission();
		missionRescueRobin.setName("Young Justice - Rescue Robin");
		missionRescueRobin.setCreated(Calendar.getInstance().getTime());

		missionRepository.persist(missionRescueRobin);

		Mission missionDefeatBraniac = new Mission();
		missionDefeatBraniac.setName("Young Justice - Defeat Braniac");
		missionDefeatBraniac.setCreated(Calendar.getInstance().getTime());

		missionRepository.persist(missionDefeatBraniac);

		// associate hero with mission
		superBoy.setMissionList(Arrays.asList(missionRescueRobin, missionDefeatBraniac));
		missionRepository.merge(missionDefeatBraniac);

		System.out.println(superBoy);

		//

		// *** *** *** ***

		// EXERCISE 4
		// cascade
		Team martians = new Team();
		martians.setName("Martians");

		Hero missMartian = new Hero();
		missMartian.setFullName("Miss Martian");
		missMartian.setTeam(martians);

		// neither team or hero is persisted
		System.out.println(teamRepository.findAll());
		heroRepository.persist(missMartian);
		System.out.println(teamRepository.findAll());


		// *** *** *** ***
		// HQL

		// find all applications
		System.out.println(heroRepository.findAll());

		// find team by id

		// find hero by name

		// SQL


		System.exit(0);
	}

}
