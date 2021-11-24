package lotto.view;

import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class InputView {
    private InputPrice inputPrice;
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputView(InputPrice inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void inputPrice() {
        System.out.println(MSG_INPUT_PRICE);
        inputPrice = new InputPrice(Integer.valueOf(scanner.next()));
        if (inputPrice.validateSmallestUnit()) {
            System.exit(NUMBER_ZERO);
            throw new IndexOutOfBoundsException(MSG_MINIMUM_PURCHASE_PRICE);
        }
    }

    public LottoNumbers inputLastWeekWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        String[] lastWeekWinningNumbers = scanner.next().split(COMMA);
        validLottoNumberLength(lastWeekWinningNumbers);
        return new LottoNumbers(Arrays.stream(lastWeekWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public void validLottoNumberLength(String[] lottoNumber) {
        if (lottoNumber.length > NUMBER_SIX) {
            throw new IndexOutOfBoundsException("지난 주 당첨 번호는 6개만 입력할 수 있습니다.");
        }
    }

    public LottoGameCount getLottoGameCount() {
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
