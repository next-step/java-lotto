package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    private InputView() {}

    public static Money inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(Integer.parseInt(SCANNER.nextLine()));
    }

    public static Lotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> winningLottoNumbers = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(numberString -> new LottoNumber(Integer.parseInt(numberString)))
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

}
