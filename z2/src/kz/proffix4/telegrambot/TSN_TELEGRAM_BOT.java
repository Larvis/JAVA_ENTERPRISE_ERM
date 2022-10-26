package kz.proffix4.telegrambot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

class MyTelegramBot extends TelegramLongPollingBot {

    // Связь с пользователем бота, тут ничего не трогаем
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
            sendMessage.setText(doCommand(update.getMessage().getChatId(),
                    update.getMessage().getText()));
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
            }
        }
    }

    // Тут задается нужное значение имени бота
    @Override
    public String getBotUsername() {
        return "The test of the testing dev BOT";
    }

    // Тут задается нужное значение токена для связи с Telegram
    @Override
    public String getBotToken() {
        return "5447748439:AAFGCd7Qv_6CRbI7L--OS-ugqaJHFFxe9pk";
    }

    // Метод обработки команд бота
    public String doCommand(long chatId, String command) {
        double a, b, x;
        if (command.startsWith("/sol")) {
            
            String[] param = command.split(" ");
            
            try { // НАЧАЛО ЗАЩИЩЕННОГО БЛОКА

                // Чтение данных из компонент
                a = Double.parseDouble(param[1]);
                b = Double.parseDouble(param[2]);
                x = Double.parseDouble(param[3]);


            } catch (Exception e) { // ЧТО ДЕЛАТЬ ЕСЛИ ВОЗНИКНЕТ ОШИБКА В БЛОКЕ МЕЖДУ "TRY" И "CATCH":

               return "Неправильный формат аргументов, попробуйте ещё раз!";

            }  

            if (param.length == 4) {
                return "Решение: " + getSolution(a, b, x);
            } else {
                return "Недостаточно аргументов, попробуйте ещё раз!";
            }
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(chatId));
        sendPhoto.setPhoto(new InputFile(new File("sol.png")));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException ex) {

        }
        return "Для решения данного уравнения введите команду /sol и значения A B X через пробел \nНапример  /sol 1 2 3";
    }

    private double getSolution(double a, double b, double x) {
        double y;
        // Основной алгоритм
        if (x < 8)
        {
            y = 6 * (Math.pow(a, 2) + x + Math.pow(b, 2)) / (a * b * x);
        }
        else
        {
            y = 4 * (Math.pow(a, 2) - x + Math.pow(b, 2));
        }
        return y;
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRegister() {
        super.onRegister(); //To change body of generated methods, choose Tools | Templates.
    }
}

public class TSN_TELEGRAM_BOT extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration          
    
    
    public static void main(String args[]) {
        new TSN_TELEGRAM_BOT();
    }

    public TSN_TELEGRAM_BOT() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Задаём настройки элементов на форме
        setBounds(600, 300, 350, 300);
        setTitle("Server");
        
        jButton1.setText("Start Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stop Server");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

       setVisible(true);
    }// </editor-fold> 
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyTelegramBot());
        } catch (TelegramApiException e) {
        }   
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }   

}
