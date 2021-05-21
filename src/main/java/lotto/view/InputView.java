package lotto.view;

import lotto.domain.PositiveNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String LOTTO_WON_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public PositiveNumber money() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.next());

        return new PositiveNumber(money);
    }

    public LottoWon wonNumbers() {
        return new LottoWon(wonLottoNumbers(), bonusNumber());
    }

    private Set<LottoNumber> wonLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(
                scanner.next()
                        .split(LOTTO_WON_DELIMITER)
        )
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private LottoNumber bonusNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return LottoNumber.of(Integer.parseInt(scanner.next()));
    }
}
