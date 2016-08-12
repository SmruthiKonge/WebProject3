package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.model.UserLogin;

@Repository(value = "userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserLoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(UserLogin userLogin) {
		sessionFactory.getCurrentSession().saveOrUpdate(userLogin);

	    // Can also do in this way also
		// Session session = sessionFactory.getCurrentSession();
		// session.saveOrUpdate(userLogin);
	}

	@Transactional
	public void delete(String id) {
		UserLogin userToDelete = new UserLogin();
		userToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}

	@Transactional
	public UserLogin get(String id) {

		// sessionFactory.getCurrentSession().get(UserLogin.class,id);
		String hql = "from User_Login where userId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserLogin> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean isValidUser(String name, String password)
	{
		//select * from UserDetails where id='niit' and password='niit'
		String hql = "from UserDetails where id =  '" + name + "'and password='" +password+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("deprecation")
		List list = q.list();
		
		if(list == null || list.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	@Transactional
	public List<UserLogin> list() {
		@SuppressWarnings("unchecked")
		List<UserLogin> list = (List<UserLogin>) sessionFactory.getCurrentSession().createCriteria(UserLogin.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	public UserDetails getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
