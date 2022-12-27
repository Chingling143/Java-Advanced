package com.vti;

import java.sql.Date;
import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {	
		GroupRepository repository = new GroupRepository();
		
		System.out.println("***********GET ALL GROUP***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}
		
		System.out.println("\n\n***********GET GROUP BY ID***********");

		Group groupById = repository.getGroupByID((short) 2);
		System.out.println(groupById);
		
		System.out.println("\n\n***********GET GROUP BY NAME***********");

		Group groupByName = repository.getGroupByName("Marketing");
		System.out.println(groupByName);
		
		System.out.println("\n\n***********CREATE GROUP***********");

		Group groupCreate = new Group();
		groupCreate.setName("Human Resources");
		groupCreate.setCreateDate(Date.valueOf("2022-11-04"));
		repository.createGroup(groupCreate);
		
		System.out.println("\n\n***********UPDATE GROUP***********");

		Group groupUpdate = new Group();
		groupUpdate.setId((short) 3);
		groupUpdate.setName("Security");
		groupUpdate.setCreateDate(Date.valueOf("2022-11-04"));
		repository.updateGroup(groupUpdate);
		
		System.out.println("\n\n***********DELETE GROUP***********");
		repository.deleteGroup((short) 4);

		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
		System.out.println(repository.isGroupExistsByID((short) 1));

		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
		System.out.println(repository.isGroupExistsByName("Security"));
	}
}
