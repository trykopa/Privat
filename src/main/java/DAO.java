import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    ExRateBean get(long id);

    ExRateBean getByDate(String date);

    ExRateBean getLast();

    List<ExRateBean> getAll();

    void save(ExRateBean t);

}
