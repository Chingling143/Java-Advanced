package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Group;

public class GroupRepository {
	
	private SessionFactory sessionFactory;
	
	public GroupRepository() {
		sessionFactory = buildSessionFactory();
	}
	
	private SessionFactory buildSessionFactory() {
		// load configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Group.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups() {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Group getGroupByID(short id) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();

			// get group by id
			Group group = session.get(Group.class, id);

			return group;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Group getGroupByName(String name) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group WHERE name = :name");

			// set parameter
			query.setParameter("name", name);

			// get result
			Group group = query.uniqueResult();

			return group;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createGroup(Group group) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// create
			session.save(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateGroup(Group group) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// update
			session.update(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteGroup(short id) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// get group
			Group group = (Group) session.load(Group.class, id);

			// delete
			session.delete(group);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isGroupExistsByID(short id) {

		// get group
		Group group = getGroupByID(id);

		// return result
		if (group == null) {
			return false;
		}

		return true;
	}

	public boolean isGroupExistsByName(String name) {
		Group group = getGroupByName(name);

		if (group == null) {
			return false;
		}
		return true;
	}
	
}
