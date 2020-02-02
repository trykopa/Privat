import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ExRateBeanDAO implements DAO {
    EntityManager em = JPAUtility.getEntityManager();
    @Override
    public ExRateBean get(long id) {
        ExRateBean bean = (ExRateBean) em.createQuery("SELECT c from ExRateBean c where c.id = ?1")
                .setParameter(1, id)
                .getSingleResult();
        return bean;
    }

    @Override
    public ExRateBean getByDate(String date) {
        ExRateBean bean = (ExRateBean) em.createQuery("SELECT c from ExRateBean c where c.date = ?1")
                .setParameter(1, date)
                .getSingleResult();
        return bean;
    }

    @Override
    public ExRateBean getLast() {
        if (em.createQuery("SELECT c FROM ExRateBean c").getResultList().isEmpty()){
            return null;
        } else {
            long id = (Long) em.createQuery("SELECT max (c.id) from ExRateBean c")
                    .getSingleResult();
            ExRateBean bean = (ExRateBean) em.createQuery("SELECT c from ExRateBean c where c.id = ?1")
                    .setParameter(1, id)
                    .getSingleResult();
            return bean;
        }
    }


    @Override
    public List getAll() {

        List<ExRateBean> all = em.createQuery("SELECT c from ExRateBean c")
                .getResultList();
        return all;
    }

    @Override
    public void save(ExRateBean o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }


}
