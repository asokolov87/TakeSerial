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
 * Для свичей производителя Cisco
 *
 * получает ответ от свича на команду, и проверяем ответ на наличие серийника
 */

public class Cisco {


    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static String Serial;


}

