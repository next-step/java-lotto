package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY_REGEX = "\\s+";
    Scanner scanner = new Scanner(System.in);

    public long inputPurchaseAmount() {
        return scanner.nextLong();
    }

    public List<LottoNumber> inputLuckyNumbers() {
        scanner.nextLine();
        String[] numbers = scanner.nextLine()
                .replaceAll(EMPTY_REGEX, "")
                .split(SPLIT_REGEX);
        List<LottoNumber> luckyNumbers = new ArrayList<>();
        for (String number : numbers) {
            luckyNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
        return luckyNumbers;
    }

    public int inputBonusNumber() {
        return scanner.nextInt();
    }

}
