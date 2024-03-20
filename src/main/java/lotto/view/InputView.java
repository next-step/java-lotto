package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    public int inputPrice() {
        return SCANNER.nextInt();
    }

    public void inputNextLine() {
        SCANNER.nextLine();
    }

    public String[] inputWinningNumbers() {
        return SCANNER.nextLine().split(SPLIT_REGEX);
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : inputWinningNumbers()) {
            winningNumbers.add(Integer.parseInt(numberString));
        }
        return winningNumbers;
    }

}
