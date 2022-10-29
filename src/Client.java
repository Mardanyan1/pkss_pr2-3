import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Client
{
    // инициализируйте сокет и входной поток
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    // constructor to put ip address and port

    public Client(String address, int port)
    {
        // установка соединения
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");


            // принимает входные данные с терминала
            input = new DataInputStream(System.in);

            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


            // отправляет выходные данные в сокет
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // строка для чтения сообщения из входных данных
        String line = "";

        int num = 0;

        // продолжайте читать, пока не будет введено "Over".
        while (!line.equals("Over"))
        {
            try
            {
                System.out.println("Введи какой номер задачи вам нужен:");
                num = Integer.parseInt(input.readLine());
                out.writeUTF(String.valueOf(num));

                switch (num) {
                    case (15): {
                        String a = "";
                        String b = "";
                        System.out.println("Первый массив через пробел:");
                        a = String.valueOf(input.readLine());

                        System.out.println("Второй массив через пробел:");
                        b = String.valueOf(input.readLine());

                        System.out.println(a);
                        System.out.println(b);

                        out.writeUTF(a);
                        out.writeUTF(b);
                        break;
                    }
                    case (18): {
                        String a = "";
                        String b = "";
                        String c = "";
                        String d = "";
                        System.out.println("Первая пара через пробел:");
                        a = String.valueOf(input.readLine());

                        System.out.println("Вторая пара через пробел:");
                        b = String.valueOf(input.readLine());

                        System.out.println("Третья пара через пробел:");
                        c = String.valueOf(input.readLine());

                        System.out.println("Четвертая пара через пробел:");
                        d = String.valueOf(input.readLine());

                        System.out.println(a);
                        System.out.println(b);

                        out.writeUTF(a);
                        out.writeUTF(b);
                        out.writeUTF(c);
                        out.writeUTF(d);
                        break;
                    }
                    case (21): {
                        System.out.print("a = ");
                        double a = Double.parseDouble(input.readLine());
                        System.out.print("c = ");
                        double c = Double.parseDouble(input.readLine());
                        out.writeDouble(a);
                        out.writeDouble(c);
                        break;
                    }
                    case (24):{
                        System.out.print("t = ");
                        double t = Double.parseDouble(input.readLine());
                        System.out.print("s = ");
                        double s = Double.parseDouble(input.readLine());
                        out.writeDouble(t);
                        out.writeDouble(s);
                        break;
                    }
                    case (27):  {
                        System.out.print("n = ");
                        int n = Integer.parseInt(input.readLine());
                        out.writeInt(n);
                        break;
                    }
                    case (115): {
                        int n = 0;
                        System.out.print("n = ");
                        while (!(n>0 && n%3==0))
                        {
                            n = Integer.parseInt(input.readLine());
                            out.writeInt(n);
                        }
                        break;
                    }
                    case (118):
                        break;
                    case (121): {
                        System.out.print("n = ");
                        int n = Integer.parseInt(input.readLine());
                        out.writeInt(n);
                    }
                        break;
                    case (124): {
                        System.out.print("n = ");
                        int n = Integer.parseInt(input.readLine());
                        out.writeInt(n);
                        break;
                    }
                    case (127): {
                        System.out.print("n = ");
                        int n = Integer.parseInt(input.readLine());
                        System.out.println("sending...");
                        out.writeInt(n);
                    }
                        /*boolean bool = input.readBoolean();
                        if (bool == true) {
                            System.out.println(n + " является степенью 4");
                        }
                        else {
                            System.out.println(n + " не является степенью 4");
                        }*/
                        break;
                    default:
                        break;
                }
            }
            catch(IOException i)
            {
                System.out.println("PRIKOL");
                System.out.println(i);
            }
        }
        // закрытие соединения
        try
        {
            input.close();

            out.close();

            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }
}