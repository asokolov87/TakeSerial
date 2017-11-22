package switches;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by sokolov on 17.11.2017.
 *
 * Для свичей производителя DLink
 *
 * получает ответ от свича на команду, и проверяем ответ на наличие серийника
 */
public class Dlink {


    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static String Serial;

    public static String getSerial(String address) {
        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            socket = new Socket(ipAddress, 23);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socket.setSoTimeout(10000);

            out.println("login");
            out.println("pass");

            //для свичей DLink
            out.println("show switch");

            String response;

            while ((response = in.readLine()) != null) {
                if (response.contains("erial")) {
                    Serial = response.substring(response.indexOf(":")+1);
                    break;
                }
            }
            out.close();
            in.close();
            socket.close();

        }
        catch (SocketException e){
            return (address + "   Превышено время ожидания");
        }
        catch (Exception e) {
            return (address + "   Информация отсутствует");
        }
        return address + "   " + Serial;
    }

}
