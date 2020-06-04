package spring.intro.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.intro.dao.UserDao;
import spring.intro.model.UserResponseDto;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(UserResponseDto userResponseDto) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(userResponseDto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't create userResponseDto");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<UserResponseDto> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM UserResponseDto");
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of users");
        }
    }

    @Override
    public UserResponseDto get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM UserResponseDto WHERE userId = :userId");
            query.setParameter("userId", id);
            return (UserResponseDto) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Can't get user");
        }
    }
}
