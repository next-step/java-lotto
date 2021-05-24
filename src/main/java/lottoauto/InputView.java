package lottoauto;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String next() {
        return SCANNER.next();
    }

    public int nextInt() {
        return SCANNER.nextInt();
    }
}
