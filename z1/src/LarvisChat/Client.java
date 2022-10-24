package LarvisChat;

//import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {
    private Socket clientSocket;
    private Scanner inMessage;    // входящие сообщение
    private PrintWriter outMessage; // исходящие сообщение
    
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMessage;
    
    private String clientName = "";

    public String getClientName() {
        return this.clientName;
    }

    // конструктор
    public Client() {
        try {
            // подключаемся к серверу
            clientSocket = new Socket(Const.HOST, Const.PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Задаём настройки элементов на форме
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        // label, который будет отражать количество клиентов в чате
//        JLabel jlNumberOfClients = new JLabel("Количество клиентов в чате: ");
//        add(jlNumberOfClients, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        jtfMessage = new JTextField();
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jtfName = new JTextField("Никнейм ", 10);
        bottomPanel.add(jtfName, BorderLayout.WEST);
        // обработчик события нажатия кнопки отправки сообщения
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // если имя клиента, и сообщение непустые, то отправляем сообщение
                if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                    clientName = jtfName.getText();
                    sendMsg();
                    // фокус на текстовое поле с сообщением
                    jtfMessage.grabFocus();
                }
            }
        });
        
        // очистка поля сбщ при фокусе
        jtfMessage.addFocusListener(new FocusAdapter() {
          @Override
          public void focusGained(FocusEvent e) {
            jtfMessage.setText("");
          }
        });
        // очистка поля имя при фокусе
        jtfName.addFocusListener(new FocusAdapter() {
          @Override
          public void focusGained(FocusEvent e) {
            jtfName.setText("");
          }
        });
       
        // Новый поток работы с сервером
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        // Если входящее сообщение
                        if (inMessage.hasNext()) {
                            String inMes = inMessage.nextLine();  // считываем сбщ
                            jtaTextAreaMessage.append(inMes + "\n"); // Вывод сообщения
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        
        // При закрытии клиента
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    // здесь проверяем, что имя клиента непустое
                    if (!clientName.isEmpty()) {
                        outMessage.println(clientName + " вышел из чата!");
                    } else {
                        outMessage.println("Участник вышел из чата, так и не представившись!");
                    }
                    // Закрытие сессии
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {

                }
            }
        });
        // отображаем форму
        setVisible(true);
    }

    // отправка сообщения
    public void sendMsg() {
        // формируем сообщение для отправки на сервер
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();
        // отправляем сообщение
        outMessage.println(messageStr);
        outMessage.flush();
        jtfMessage.setText("");
    }
}

