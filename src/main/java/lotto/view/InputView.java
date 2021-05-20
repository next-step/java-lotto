package lotto.view;

import lotto.domain.PositiveInteger;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String LOTTO_WON_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public PositiveInteger money() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.next());

        return new PositiveInteger(money);
    }

    public LottoWon wonNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.next();

        return new LottoWon(Arrays.stream(numbers.split(LOTTO_WON_DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }
}
