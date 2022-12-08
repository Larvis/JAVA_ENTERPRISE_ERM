package tsn.java.soap;

//import java.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Указываем специальные аннотации, что класс будет работать в web-технологии SOAP
@WebService
@SOAPBinding(style = Style.RPC)

public class CommunicationWithClient implements ICommunicationWithClient {

    // Решение квадратного уровнения
    @Override
    public AnswerQE quadraticEquation(double a, double b, double x) {
        double y;
//        
        try {
//            desc = Math.pow(b, 2) - 4 * a * c;
//            x1 = -b + Math.sqrt(desc);
//            x2 = -b - Math.sqrt(desc);
//            if ((Double.isNaN(x1)) || (Double.isInfinite(x1)) || (Double.isNaN(x2)) || (Double.isInfinite(x2))) {
//                throw new Exception();
//            }
//            AnswerQE otvet = new AnswerQE(x1, x2);
//            return otvet;

            if (x < 8)
            {
                y = (6 * Math.pow(a, 2) + x + Math.pow(b, 2)) / ((a * b * x));
            }
            else
            {
                y = 4 * (Math.pow(a, 2) - x + Math.pow(b, 2));
            }
            AnswerQE otvet = new AnswerQE(y);
            
            return otvet;
        } catch (Exception e) {
            return null;
        }
        
        
    }

}
