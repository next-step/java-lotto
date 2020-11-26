package humbledude.lotto.view;

import humbledude.lotto.domain.Budget;
import humbledude.lotto.domain.LottoNumber;
import humbledude.lotto.domain.LottoNumbers;
import humbledude.lotto.domain.LottoWinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class InputView {

    private static final String MSG_INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private static final String MSG_INPUT_AMOUNT_OF_MANUAL = "수동으로 구입할 로또 수를 입력해 주세요";
    private static final String MSG_INPUT_NUMBER_OF_MANUAL = "수동으로 구입할 번호를 입력해 주세요";
    private static final String MSG_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    private static final String MSG_INPUT_WINNING_BONUS_NUMBER = "보너스 볼을 입력해 주세요";

    private static final Scanner scanner = new Scanner(System.in);

    public static Budget getBudget() {
        System.out.println(MSG_INPUT_BUDGET);
        return new Budget(Long.parseLong(scanner.nextLine()));
    }

    public static long getAmountOfManualLotto() {
        System.out.println(MSG_INPUT_AMOUNT_OF_MANUAL);
        return Long.parseLong(scanner.nextLine());
    }

    public static List<LottoNumbers> getNumberOfManualLottos(long amount) {
        System.out.println(MSG_INPUT_NUMBER_OF_MANUAL);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (long i = 0; i < amount; i++) {
            LottoNumbers numbers = readLottoNumbersFromScanner();
            lottoNumbersList.add(numbers);
        }

        return lottoNumbersList;
    }

    public static LottoWinningNumbers getWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        LottoNumbers numbers = readLottoNumbersFromScanner();

        System.out.println(MSG_INPUT_WINNING_BONUS_NUMBER);
        LottoNumber bonus = LottoNumber.of(Integer.parseInt(scanner.nextLine()));

        return new LottoWinningNumbers(numbers, bonus);
    }

    private static LottoNumbers readLottoNumbersFromScanner() {
        return new LottoNumbers(Stream.of(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }
}
