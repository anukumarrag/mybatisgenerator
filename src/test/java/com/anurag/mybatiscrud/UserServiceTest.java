package com.anurag.mybatiscrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.mybatiscrud.domain.User;
import com.anurag.mybatiscrud.domain.UserExample;
import com.anurag.mybatiscrud.service.UserService;

@SpringBootTest
@Transactional
public class UserServiceTest {

	@Autowired
	private UserService userService;

	private static User sampleUser = null;

	@BeforeAll
	public static void setUp() {

		sampleUser = new User();
		sampleUser.setId(String.valueOf(System.currentTimeMillis()));
		sampleUser.setFirstName("Anurag");
		sampleUser.setLastName("Kumar");
		sampleUser.setCreatedBy("Anurag.kumar");
		sampleUser.setCreatedTime(new Date());
		sampleUser.setPreferredLanguage("English");
		sampleUser.setBackgroundCheck(1);

	}

	@Test
	public void insertTest() {

		int count = userService.insert(sampleUser);
		assertTrue(count == 1);
	}

	@Test
	public void getUserByExampleTest() {

		// Insert an User before fetching User from database.
		insertTest();

		// Create an UserExample for fetching User with ID = SampleUser.Id
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdEqualTo(sampleUser.getId());

		List<User> users = userService.getUserByExample(userExample);
		assertTrue(users.size() == 1);
		assertTrue(users.get(0).getId().equals(sampleUser.getId()));
	}

	@Test
	public void updateUserByExampleTest() {

		// Step 1: Insert User
		insertTest();

		// Step 2: make some changes in User object
		sampleUser.setLastUpdatedBy("manoj.kumar");

		// Create an UserExample for sampleUser
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdEqualTo(sampleUser.getId());

		// Step 3: Update User
		int updateCount = userService.updateUserByExample(sampleUser, userExample);

		assertTrue(updateCount == 1);

		// Step 4: Now fetch Updated user and verify the changes you made.
		List<User> users = userService.getUserByExample(userExample);
		assertTrue(users.size() == 1);
		assertEquals(users.get(0).getLastUpdatedBy(), sampleUser.getLastUpdatedBy());

	}

	@Test
	public void deleteUserByExampleTest() {

		// Step 1: Insert User
		insertTest();

		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdEqualTo(sampleUser.getId());

		// Step 2:
		int deleteCount = userService.deleteUserByExample(userExample);
		assertTrue(deleteCount == 1);

		// Step 3, try to fetch the same user and verify that it's deleted
		List<User> users = userService.getUserByExample(userExample);
		assertTrue(users.isEmpty());

	}

}
