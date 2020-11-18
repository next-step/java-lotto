package humbledude.lotto.view;

import humbledude.lotto.domain.LottoNumber;
import humbledude.lotto.domain.LottoWinningNumbers;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String MSG_INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";

    private static final Scanner scanner = new Scanner(System.in);

    public static long getBudget() {
        System.out.println(MSG_INPUT_BUDGET);
        return Long.parseLong(scanner.nextLine());
    }

    public static LottoWinningNumbers getWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        Set<LottoNumber> numbers = Stream.of(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());

        return new LottoWinningNumbers(numbers);

    }

}
