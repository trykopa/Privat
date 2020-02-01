import org.joda.time.LocalDate;
import java.text.ParseException;

public class UpdateDB {
    static final int HISTORY_YEARS = 1;
    public static void main(String[] args) throws ParseException {
        ServiceCLS sc = new ServiceCLS();
        ExRateBeanDAO dao = new ExRateBeanDAO();

        String myURL = "https://api.privatbank.ua/p24api/exchange_rates?json&date=";
        LocalDate now = LocalDate.now();
        //LocalDate start = now.minusMonths(HISTORY_YEARS);

        String last = dao.getLast().getDate();
        System.out.println(last);
        LocalDate start = sc.stringToLocalDate(last);
        for (LocalDate date = start.plusDays(1); date.isBefore(now.plusDays(1)); date = date.plusDays(1)) {
            String target = myURL + sc.dateString(date);
            String responce =  sc.getResponse(target);
            ExRateBean tmpBean = sc.extractBeanFromJSON(responce);
            dao.save(tmpBean);
        }

    }
}
