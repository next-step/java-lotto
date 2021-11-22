package step2_2;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int readInt() {
        return SCANNER.nextInt();
    }
    
    public String readLine() {
        return SCANNER.nextLine();
    }
}
