package spring.intro.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.intro.dao.UserDao;
import spring.intro.model.User;
import spring.intro.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't create user");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User");
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of users");
        }
    }
}