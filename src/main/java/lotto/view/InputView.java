package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner sScanner = new Scanner(System.in);
    private final static Scanner iScanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputText() {
        return sScanner.nextLine();
    }

    public static Integer inputInt() {
        return iScanner.nextInt();
    }

    public static List<String> inputManualLotto(int manualCount) {
        List<String> autoText = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            autoText.add(inputText());
        }
        return autoText;
    }
}
