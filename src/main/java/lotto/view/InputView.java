package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.User;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String LAST_WEEK_LOTTO_RESULT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        User user = new User(new Money(scanner.nextInt()));
        clearBuffer();

        return user;
    }

    public LottoResult getLastWeekLottoResult() {
        System.out.println(LAST_WEEK_LOTTO_RESULT_MESSAGE);
        List<LottoNumber> lottoNumbers = Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(toList());
        System.out.println();

        return new LottoResult(lottoNumbers);
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
