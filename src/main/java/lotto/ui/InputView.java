package lotto.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {

    }

    public int getLottoPurchaseAmount() {
        String line = SCANNER.nextLine();
        return parseInt(line);
    }

    private int parseInt(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public List<Integer> getLastWinningNumber() {
        String line = SCANNER.nextLine();
        String[] numericStrings = line.split(DELIMITER);

        return toIntegerList(numericStrings);
    }

    private List<Integer> toIntegerList(String[] numericStrings) {
        List<Integer> integerList = new ArrayList<>();
        for (String numericString : numericStrings) {
            integerList.add(parseInt(numericString));
        }
        return integerList;
    }
}
