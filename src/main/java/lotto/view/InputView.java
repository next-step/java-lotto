package lotto.view;

import lotto.LottoNumber;
import lotto.LottoNumbers;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.LottoPaper.LOTTO_PRICE;

public class InputView {
    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String PURCHASE_RESULT_MESSAGE = "개를 구매했습니다.";
    private final static String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public Integer inputCount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        Integer amount = Integer.parseInt(scanner.nextLine());
        int count = amount / LOTTO_PRICE;
        System.out.println(count + PURCHASE_RESULT_MESSAGE);

        return count;
    }

    public LottoNumbers inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = scanner.nextLine();
        String[] numbers = input.split(WINNING_NUMBERS_DELIMITER);

        return new LottoNumbers(Arrays.stream(numbers)
                    .map(Integer::valueOf)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
    }
}
