package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView {

    private static final LottoInputView INPUT_VIEW = new LottoInputView();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_COUNT_VALUE = 0;

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

    private List<LottoNumber> inputLottoNumbers() {
        return Arrays.stream(inputString().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public int moneyInputPrompt() {
        System.out.println("구입금액을 입력해주세요.");
        return inputInteger();
    }

    public List<LottoNumber> winningInputPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumbers();
    }

    public LottoNumber bonusInputPrompt() {
        System.out.println("보너스볼 번호를 입력해 주세요.");
        return LottoNumber.from(inputInteger());
    }

    public int manualInputPrompt() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInteger();
    }

    public List<LottoNumbers> manualLottoNumbersInputPrompt(int count) {
        if (count <= MIN_COUNT_VALUE) {
            return new ArrayList<>();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, count)
                .mapToObj(i -> inputLottoNumbers())
                .map(LottoNumbers::from)
                .collect(Collectors.toList());
    }
}
