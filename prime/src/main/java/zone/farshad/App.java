package zone.farshad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        File f = new File(args[0]);
        try (FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream);
            BufferedWriter out =
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(java.io.FileDescriptor.out)),
                    2);) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                out.write(isPrime(Integer.parseInt(line)) + "\n");
            }
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
