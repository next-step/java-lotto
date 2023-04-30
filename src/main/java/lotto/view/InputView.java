package lotto.view;

import lotto.domain.LottoNumberGroup;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요 :)");
        return Money.wons(scanner.nextInt());
    }

    public static WinnerLotto inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요 :)");
        String inputWinnerLottoNumber = scanner.nextLine();
        return WinnerLotto.of(new LottoNumberGroup(), toIntList(inputWinnerLottoNumber));
    }

    private static List<Integer> toIntList(String winnerLottoNumber) {
        return Arrays.stream(winnerLottoNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
