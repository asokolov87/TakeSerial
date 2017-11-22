import switches.Dlink;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> ip_switches = new ArrayList<String>();

        //считываем ip адреса свичей и помещаем в List
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Data\\TakeSerialFromSwitch\\src\\1.txt"));
            String line;
            while ((line = reader.readLine()) != null)
                ip_switches.add(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("C:\\Data\\TakeSerialFromSwitch\\src\\2.txt", false)) {

            for(String ip : ip_switches) {

                String s = Dlink.getSerial(ip)+ "\r\n";
                writer.write(s);
                writer.flush();
                System.out.print(s);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
