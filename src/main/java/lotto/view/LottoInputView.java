package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final LottoInputView INPUT_VIEW = new LottoInputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {

    }

    public static LottoInputView getInstance() {
        return INPUT_VIEW;
    }

    private int inputInteger() {
        return SCANNER.nextInt();
    }

    private String inputString() {
        return SCANNER.next();
    }

    public int moneyInputPrompt() {
        System.out.println("구입금액을 입력해주세요.");
        return inputInteger();
    }

    public List<LottoNumber> winningInputPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(inputString().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public LottoNumber bonusInputPrompt() {
        System.out.println("보너스볼 번호를 입력해 주세요.");
        return LottoNumber.from(inputInteger());
    }
}
