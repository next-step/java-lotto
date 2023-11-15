package step1.model.scanner;

import java.util.Scanner;

public class InputLottoScanner implements LottoScanner {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Scanner get() {
        return scanner;
    }
}
