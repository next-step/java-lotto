package lotto.view;

import lotto.util.ListConverter;

import java.util.List;
import java.util.Scanner;

public class NumberInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final List<Integer> lottoNumbers;

    private NumberInputView(String stringNumbers) {
        this.lottoNumbers = ListConverter.convertCommaStringToNumberList(stringNumbers);
    }

    public static NumberInputView enterWinningLottoNumbers() {
        return new NumberInputView(getInput());
    }

    private static String getInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
