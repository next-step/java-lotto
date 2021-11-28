package lotto.view;

import lotto.domain.BonusLottoNumber;
import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class InputView {
    private static InputPrice inputPrice;
    private static final Scanner scanner = new Scanner(System.in);

    public InputView(InputPrice inputPrice) {
        this.inputPrice = inputPrice;
    }

    public static void inputPrice() {
        System.out.println(MSG_INPUT_PRICE);
        inputPrice = new InputPrice(Integer.valueOf(scanner.next()));
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

    public static LottoGameCount getLottoGameCount() {
        return new LottoGameCount(inputPrice.divideByThousands());
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
