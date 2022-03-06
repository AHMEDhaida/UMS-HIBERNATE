package com.ums.db.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ums.db.HibernateConnection;
import com.ums.db.UMSDBException;
import com.ums.model.User;

public class HibernateUserDaoImpl implements IUserDao {

	@Override
	public void create(User user) throws UMSDBException {
		try {
			Session session = HibernateConnection.getInstance().getSession();
			// Creating Transaction Object
			Transaction transaction = session.beginTransaction();
			session.save(user);
			// Transaction Is Committed To Database
			transaction.commit();
		} catch (Exception e) {
			throw new UMSDBException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public User read(int id) throws UMSDBException {
		User user = null;
		try {
			Session session = HibernateConnection.getInstance().getSession();
			user = session.find(User.class, id);
		} catch (Exception e) {
			throw new UMSDBException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return user;
	}

	@Override
	public void update(User user) throws UMSDBException {
		try {
			Session session = HibernateConnection.getInstance().getSession();
			// Creating Transaction Object
			Transaction transaction = session.beginTransaction();
			session.update(user);
			// Transaction Is Committed To Database
			transaction.commit();
		} catch (Exception e) {
			throw new UMSDBException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws UMSDBException {
		try {
			
			User user = read(id);
			
			if (user != null) {
				
				Session session = HibernateConnection.getInstance().getSession();
				
				// Creating Transaction Object
				Transaction transaction = session.beginTransaction();
				
				session.delete(user);
				
			    // Transaction Is Committed To Database
			   transaction.commit();
			}
		} catch (Exception e) {
			throw new UMSDBException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() throws UMSDBException {
		List<User> users = new ArrayList<>();
		try {
			Session session = HibernateConnection.getInstance().getSession();
			Query query = session.createQuery("From User");
			users = query.getResultList();
		} catch (Exception e) {
			throw new UMSDBException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return users;
	}
}
