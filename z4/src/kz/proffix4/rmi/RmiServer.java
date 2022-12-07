package kz.proffix4.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Класс сервера RMI
public class RmiServer implements IRemoteService {
    // Потокозащищенная логическая переменная для возможности остановки сервера
    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    // Метод получения данных
    public Object getData(Person person) {
        String y;
        if (person.getX() < 8)
        {
            y = String.valueOf((6 * (Math.pow(person.getA(), 2) + person.getX() + Math.pow(person.getB(), 2)) / (person.getA() * person.getB() * person.getX())));
        }
        else
        {
            y = String.valueOf(4 * (Math.pow(person.getA(), 2) - person.getX() + Math.pow(person.getB(), 2)));
        }
        return y;
    }

    @Override
    // Метод остановки сервера
    public void stopServer() {
        stopServer.set(true);
    }

    public static void main(String... args) throws AccessException, RemoteException, AlreadyBoundException {
        System.out.println("Starting service...");
        final IRemoteService service = new RmiServer();
        LocateRegistry.createRegistry(IRemoteService.PORT).bind(IRemoteService.SERVICE_NAME, UnicastRemoteObject.exportObject(service, 0));
        while (!stopServer.get()) { // Бесконечный цикл, пока переменная stopServer не выключит его
            try {
                Thread.sleep(100); // Небольшая задержка для правильной работы цикла в потоке
            } catch (InterruptedException e) { // Завершение потока при внешнем прерывании
                break;
            }
        }
        System.out.println("Server stopped");
        System.exit(0);
    }

}
