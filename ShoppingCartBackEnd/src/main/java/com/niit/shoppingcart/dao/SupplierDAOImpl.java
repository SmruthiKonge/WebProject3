package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository(value="supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	@Transactional
	public void delete(String id) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setSupId(id);
		sessionFactory.getCurrentSession().delete(supplierToDelete);

	}

	@Transactional
	public Supplier get(String id) {

		//return sessionFactory.getCurrentSession().get(Supplier.class, id);
		String hql = "from supplier where supplierId=" + "'" + id + "'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Supplier> listSuppliers = query.getResultList();
		 if(listSuppliers!=null && !listSuppliers.isEmpty() )
		 {
			 return listSuppliers.get(0);
		 }
		 return null;
	}

	@Transactional
	public List<Supplier> listSupplier() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSuppliers = sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSuppliers;
	}

}
