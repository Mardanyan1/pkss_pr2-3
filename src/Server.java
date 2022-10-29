import java.net.*;
import java.io.*;

import static java.lang.Math.*;


public class Server
{
    //инициализируйте сокет и входной поток
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;


    //номер 15
    public void MiddleMassives(String a, String b) throws IOException {
        double summaA = 0;
        double summaB = 0;
        String[] ary = a.split(" ");
        String[] bry = b.split(" ");

        for(int i = 0; i< ary.length; i++) {
            summaA = summaA +Integer.parseInt(ary[i]);
        }
        summaA = summaA / ary.length;

        for(int i = 0; i< bry.length; i++) {
            summaB = summaB + Integer.parseInt(bry[i]);
        }
        summaB = summaB/bry.length;
        summaA = (summaB+summaA)/2;
        String strSumma = String.valueOf(summaA);
        System.out.println("Срденее двух массивов = " + summaA);
    }

    //номер 18
    public void NOD(String a, String b, String c, String d)
    {
        int summaA = 0;
        int summaB = 0;
        int summaC = 0;
        int summaD = 0;
        String[] ary = a.split(" ");
        String[] bry = b.split(" ");
        String[] cry = c.split(" ");
        String[] dry = d.split(" ");
        System.out.println(gcd(Integer.parseInt(ary[0]),Integer.parseInt(ary[1])));
        System.out.println(gcd(Integer.parseInt(bry[0]),Integer.parseInt(bry[1])));
        System.out.println(gcd(Integer.parseInt(cry[0]),Integer.parseInt(cry[1])));
        System.out.println(gcd(Integer.parseInt(dry[0]),Integer.parseInt(dry[1])));
    }
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    //номер 21
    public void triangle(double a, double c)
    {
        double b = sqrt(c*c-a*a);
        System.out.println("Катет равен " + b);
    }

    //номер 24
    public void Y(double s, double t)
    {
        System.out.println( G(12,s)+G(t,s)-G(2*s-1,s*t));
    }
    public double G(double a, double b)
    {
        return (2*a+b*b)/(a*b*2+b*5);
    }
    //номер 27
/*    public void simpleNum(int n) {
        *//*int count = 0;
        int countNum = 0;
        boolean bool = true;
        for (int i = 1; i<n;i++)
        {
            for (int j = 2; j<=i;j++)
            {
                if (!(i%j==0) || (i==j))
                {
                    countNum++;
                    bool = false;
                }

            }

            if (bool == true)
            {
                count++;
                System.out.println(count + " простое число");
            }
            countNum = 0;
        }
        System.out.println("всего " + count + " простых чисел");
        if (count>0)
        {
            int cont = 0;
            for (int j = 2; j<count;j++)
            {
                if (count%j==0)
                    break;
                else cont++;
            }
        }

*//*
    }*/
    static int var = 2;
    static int simplNum = 0;
    private static void checkIsItANaturalNumber(int j) {
        if (j > 1) {
            if (j % var != 0) {
                var++;
                checkIsItANaturalNumber(j);
            } else if (j % var == 0) {
                printIsItNaturalNumber(var, j);
                var = 2;
            }
        }

    }
    private static void printIsItNaturalNumber(int var, int n) {
        if (var == n) {
            System.out.println(n + " is a natural number.");
            simplNum++;
        } else {
            System.out.println(n + " is not a natural number.");
        }
    }

    //номер 15.2
    /*public void plusOst(int n)
    {
        while (n<0 && n%3>0)
        {
            int n = in.readInt();

        }
    }*/
    //номер 18.2
    public void graphics() {
        for (double x = 3.0; x <= 8.0; x += 0.9)
        {
            double z = log(x) + tan(2 * x);
            if (z > 1.0)
            {
                System.out.println("z = " + z);
            }
        }
    }
    //номер 21.2
    public void firstNum(int n) {
        int nn = n;
        while (nn>10)
        {
            nn=nn/10;
        }
        System.out.println("Первая цифра это " + nn);
    }
    //номер 24.2
    public void minimFive(int n) {
        int k = 0;
        int res = 0;
        while (n > Math.pow(5, k)) {
            k++;
            res = (int) Math.pow(5, k);
        }
        System.out.println("Наименьшее число вида 5^k, большее n: " + res);
    }
    //номер 27.2
    public void Natural(int n) throws IOException {
        double i = log(n) / log(4);

        boolean res;
        if (i == Math.floor(i)) {
            System.out.println(n + " является степенью 4");
            res = true;
        }
        else {
            System.out.println(n + " не является степенью 4");
            res = false;
        }
//        System.out.println("first");
////        boolean bool = Boolean.parseBoolean(in.readLine());
//        System.out.println("second");
//        out.writeBoolean(res);
//        System.out.println("third");
    }



    // конструктор с портом
    public Server(int port)
    {
        // запускает сервер и ожидает подключения
        try
        {
            server = new ServerSocket(port);

            System.out.println("Сервер запущен");
            System.out.println("Ждем клиента ...");

            socket = server.accept();
            System.out.println("Клиент подключен");

            // принимает входные данные от клиентского сокета
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // отправляет выходные данные в сокет
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            String line = "";
            int nummer = 0;

            // считывает сообщение от клиента до тех пор, пока не будет отправлено "Over".
            while (!line.equals("Over"))
            {
                try
                {

                    nummer = Integer.parseInt(in.readUTF());

                    System.out.println("Hello, nummer is " + nummer);
                    switch (nummer) {
                        case (15): {
                            String a = in.readUTF();
                            String b = in.readUTF();
                            MiddleMassives(a, b);
                            break;
                        }
                        case (18): {
                            String a = in.readUTF();
                            String b = in.readUTF();
                            String c = in.readUTF();
                            String d = in.readUTF();
                            NOD(a, b, c, d);
                            break;
                        }
                        case (21): {
                            double a = in.readDouble();
                            double c = in.readDouble();
                            triangle(a,c);
                            break;
                        }
                        case (24): {
                            double t = in.readDouble();
                            double s = in.readDouble();
                            Y(t,s);
                            break;
                        }
                        case (27):  {
                            int n = in.readInt();
                            for (int j = 2; j<=n;j++)
                            {
                                checkIsItANaturalNumber(j);
                            }
                            checkIsItANaturalNumber(simplNum);
                            break;
                        }
                        case (115): {
                            int n = 0;
                            while (!(n>0 && n%3==0)) {
                                n = in.readInt();
                                System.out.println("вы ввели "+n +" и получили "+n*n);
                            }
                            System.out.println("Было введено положительное число, кратное 3");
                            break;
                        }
                        case (118): {
                            graphics();
                            break;
                        }
                        case (121): {
                            int n = in.readInt();
                            firstNum(n);
                            break;
                        }
                        case (124): {
                            int n = in.readInt();
                            minimFive(n);
                            break;
                        }
                        case (127): {
                            int n = in.readInt();
                            Natural(n);
                            break;
                        }
                        default: {
                            break;
                        }
                    }

                    //введенные данные клиентом
                    /*line = in.readUTF();

                    System.out.println(line);*/
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            // закрытие соединения
            socket.close();

            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}