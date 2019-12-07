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
		Team team = new Team();
		team.setName("Avengers");

		teamRepository.persist(team);
		System.out.println("Id: " + team.getId() + " - Name: " + team.getName());

		// merge team
		team.setName("Justice League");
		teamRepository.merge(team);

		System.out.println("Team updated: " + team);

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

		System.out.println("User to enter at the Hall of Justice: " + user);

		// *** *** *** ***

		// EXERCISE 3

		superBoy.setTeam(team);
		heroRepository.merge(superBoy);
		System.out.println("Superboy (with team): " + superBoy);

		// *** *** *** ***

		// EXERCISE 4
		// create new mission
		Mission missionRescueRobin = new Mission();
		missionRescueRobin.setName("Young Justice - Rescue Robin");
		missionRescueRobin.setCreated(DateTime.now().toDate());

		missionRepository.persist(missionRescueRobin);

		Mission missionDefeatBraniac = new Mission();
		missionDefeatBraniac.setName("Young Justice - Defeat Braniac");
		missionDefeatBraniac.setCreated(DateTime.now().toDate());

		missionRepository.persist(missionDefeatBraniac);

		// associate hero with mission
		superBoy.setMissionList(Arrays.asList(missionRescueRobin, missionDefeatBraniac));
		heroRepository.merge(superBoy);

		System.out.println("Superboy (full profile): " + superBoy);

		//

		// *** *** *** ***

		// EXERCISE 5
		// cascade
		Team martians = new Team();
		martians.setName("Martians");

		Hero missMartian = new Hero();
		missMartian.setFullName("Miss Martian");
		missMartian.setTeam(martians);

		// neither team or hero is persisted
		System.out.println("Before persist: " + teamRepository.findAll());
		heroRepository.persist(missMartian);
		System.out.println("After persist: " + teamRepository.findAll());

		// *** *** *** ***

		// EXERCISE 5
		// fetch type
		// spring.jpa.show-sql=true
		System.out.println(teamRepository.findAll());
		// teamRepository.findAll().stream().forEach(System.out::print);


		// *** *** *** ***

		// EXERCISE 7
		// HQL

		// find all heroes
		List<Hero> heroes = heroRepository.findAll();
		System.out.println("\nAll Heroes:\n" + heroes);


		// *** *** *** ***
		// EXERCISE 8
		// get hero ID
		Long id = heroes.get(0).getId();

		// find hero by ID
		System.out.println("Hero by Id:\n" + heroRepository.findById(id));
		System.out.println("\n" + heroRepository.findByIdHQL(id));

		// *** *** *** ***

		// EXERCISE 9
		// find hero by initial name
		System.out.println("\nHero by Name:\n" + heroRepository.findByInitialName("M"));

		// *** *** *** ***

		// EXERCISE 10
		// get the heroes of an specific mission
		System.out.println("\nAll Heroes of a Mission:\n" + heroRepository.findHeroesByMissionName("Rescue"));


		System.exit(0);
	}

}
