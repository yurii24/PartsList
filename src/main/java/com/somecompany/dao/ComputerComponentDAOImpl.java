package com.somecompany.dao;

import com.somecompany.entity.ComputerComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.somecompany.controller.ComputerComponentController.LIMIT_RESULTS_ON_PAGE;

@Repository
public class ComputerComponentDAOImpl implements ComputerComponentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<ComputerComponent> getComponents(String strQuery) {
        Session session = sessionFactory.getCurrentSession();
        Query<ComputerComponent> query = session.createQuery(strQuery, ComputerComponent.class);
        List<ComputerComponent> computerComponents = query.getResultList();

        return computerComponents;
    }

    @Override
    public List<ComputerComponent> getComponents(String strQuery, int page) {
        Session session = sessionFactory.getCurrentSession();
        Query<ComputerComponent> query = session.createQuery(strQuery, ComputerComponent.class);
        query.setFirstResult(LIMIT_RESULTS_ON_PAGE * (page - 1));
        query.setMaxResults(LIMIT_RESULTS_ON_PAGE);
        List<ComputerComponent> computerComponents = query.getResultList();

        return computerComponents;
    }

    @Override
    public void saveComponent(ComputerComponent component) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(component);
    }

    @Override
    public ComputerComponent getComponent(int id) {
        Session session = sessionFactory.getCurrentSession();
        ComputerComponent computerComponent = session.get(ComputerComponent.class, id);

        return computerComponent;
    }

    @Override
    public void deleteComponent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from ComputerComponent where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
