package kz.proffix4.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Main() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Обрабатываем кнопку <input type="submit" name="calcQE" value="Решить" /> <br />
        if (request.getParameter("calcQE") != null) {
            ResultQE resultQE = null;
            
            try {
                double a = Double.parseDouble(request.getParameter("a"));
                double b = Double.parseDouble(request.getParameter("b"));
                double c = Double.parseDouble(request.getParameter("c"));
                double x = Double.parseDouble(request.getParameter("x"));
                double y;
                
                if(x < 8)
                {
                    y = (6 * (Math.pow(a, 2) + x + Math.pow(b, 2)))/(a * b * x);
                }
                else
                {
                    y = 4 * (Math.pow(a, 2) - x + Math.pow(b, 2));
                }
                        
                resultQE = new ResultQE(y);
            } catch (Exception e) {
            }
            request.setAttribute("resultQE", resultQE);
            getServletContext().getRequestDispatcher("/result_qe.jsp").forward(request, response);
            return;
        }

        // Обрабатываем кнопку <input type="submit" name="calcSum" value="Найти сумму всех цифр" />
        if (request.getParameter("calcSum") != null) {
            try {
                double a = Double.parseDouble(request.getParameter("a"));
                double b = Double.parseDouble(request.getParameter("b"));
                double c = Double.parseDouble(request.getParameter("c"));
                double x = Double.parseDouble(request.getParameter("x"));
                double sum = a + b + c + x;
                request.setAttribute("sum", sum);
                getServletContext().getRequestDispatcher("/result_sum.jsp").forward(request, response);
                return;
            } catch (Exception e) {
                getServletContext().getRequestDispatcher("/start.jsp").forward(request, response);
                return;
            }
        }

        // Если пришел неизвестный запрос,то переход на стартовую страницу
        getServletContext().getRequestDispatcher("/start.jsp").forward(request, response);
    }

}
