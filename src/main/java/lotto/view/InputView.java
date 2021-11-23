package lotto.view;

import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;

import java.util.Objects;
import java.util.Scanner;

import static lotto.utils.Constants.*;

public class InputView {
    private InputPrice inputPrice;

    public InputView() {

    }

    public InputView(InputPrice inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MSG_INPUT_PRICE);
        inputPrice = new InputPrice(Integer.valueOf(scanner.next()));
        if (inputPrice.validateSmallestUnit()) {
            System.exit(NUMBER_ZERO);
            throw new IndexOutOfBoundsException(MSG_MINIMUM_PURCHASE_PRICE);
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
