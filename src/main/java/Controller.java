import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    private ServiceCLS sv = new ServiceCLS();
    private ExRateBeanDAO dao = new ExRateBeanDAO();
    @lombok.SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("form1".equals(request.getParameter("form"))) {
            String date = request.getParameter("date");
            if(date != null) {
                float purchase = dao.getByDate(sv.formatAndReturnDate(date)).getPurchaserate();
                float sale = dao.getByDate(sv.formatAndReturnDate(date)).getSalerate();
                request.setAttribute("purchase", purchase);
                request.setAttribute("sale", sale);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if ("form2".equals(request.getParameter("form"))) {
            String date = request.getParameter("datestart");
            String dateend = request.getParameter("dateend");
            if(date != null & dateend != null) {
                float purchase = (dao.getByDate(sv.formatAndReturnDate(date)).getPurchaserate()
                        + dao.getByDate(sv.formatAndReturnDate(dateend)).getPurchaserate())/2;
                float sale = (dao.getByDate(sv.formatAndReturnDate(dateend)).getSalerate()
                        +dao.getByDate(sv.formatAndReturnDate(dateend)).getSalerate())/2;
                request.setAttribute("avpur", purchase);
                request.setAttribute("avsale", sale);
                request.setAttribute("datestart",date);
                request.setAttribute("dateend", dateend);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
                requestDispatcher.forward(request, response);
            }
        };


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
