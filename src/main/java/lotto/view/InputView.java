package lotto.view;

import lotto.domain.BonusLottoNumber;
import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class InputView {
    private static InputPrice inputPrice;
    private static final Scanner scanner = new Scanner(System.in);

    public InputView(InputPrice inputPrice) {
        this.inputPrice = inputPrice;
    }

    public static LottoGameCount inputPrice() {
        System.out.println(MSG_INPUT_PRICE);
        inputPrice = new InputPrice(Integer.valueOf(scanner.next()));
        System.out.println(MSG_INPUT_MANUAL_COUNT);
        return new LottoGameCount(getLottoGameCount(), Integer.valueOf(scanner.next()));
    }

    public static LottoNumbers inputLastWeekWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        String[] lastWeekWinningNumbers = scanner.next().split(COMMA);
        LottoNumbers lastWeekWinnigNumbers = new LottoNumbers(Arrays.stream(lastWeekWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        lastWeekWinnigNumbers.validateLottoNumbersLength();
        System.out.println();

        return lastWeekWinnigNumbers;
    }

    public static BonusLottoNumber inputBonusLottonumber(LottoNumbers lastWeekWinningNumbers) {
        System.out.println(MSG_INPUT_BONUS_NUMBER);
        return new BonusLottoNumber(Integer.valueOf(scanner.next()), lastWeekWinningNumbers);
    }

    public static List<String[]> inputManualLottoNumbers(Integer lottoManualCount) {
        System.out.println(MSG_INPUT_MANUAL_NUMBER);
        List<String[]> inputLottos = new ArrayList<>();
        for (int i = 0; i < lottoManualCount; i++) {
            String[] inputLottoNumbers = scanner.next().split(COMMA);
            inputLottos.add(inputLottoNumbers);
        }
        return inputLottos;
    }

    private static int getLottoGameCount() {
        return inputPrice.divideByThousands();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(inputPrice, inputView.inputPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputPrice);
    }
}
