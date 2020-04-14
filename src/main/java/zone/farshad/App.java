package zone.farshad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        File f = new File(args[0]);
        try (FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream); ) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(isPrime(Integer.parseInt(line)));
            }
            final long end = System.currentTimeMillis();
            System.out.println("total time : " + (end - start));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String isPrime(int num) {
        boolean flag = false;
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < top; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return "1";
        } else {
            return "0";
        }
    }

}
