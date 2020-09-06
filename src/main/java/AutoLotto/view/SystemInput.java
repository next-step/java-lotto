package AutoLotto.view;

import java.util.Scanner;

public class SystemInput {

    private static final Scanner scanner = new Scanner(System.in);

    public int getIntValue() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public String getStringValue() {
        return scanner.nextLine();
    }
}
