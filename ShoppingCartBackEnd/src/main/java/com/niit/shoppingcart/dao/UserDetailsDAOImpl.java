package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}

	@Transactional
	public void delete(String userName) {
		UserDetails userDetailsToDelete = new UserDetails();
		userDetailsToDelete.setUserName(userName);
		sessionFactory.getCurrentSession().delete(userDetailsToDelete);

	}

	@Transactional
	public UserDetails get(String userName) {
		sessionFactory.getCurrentSession().get(UserDetails.class, userName);
		return null;
	}

	@Transactional
	public List<UserDetails> listUsers() {
		List<UserDetails> listUsers = sessionFactory.getCurrentSession().createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

}
