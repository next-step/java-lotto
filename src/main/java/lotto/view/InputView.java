package lotto.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MSG = "구입금액을 입력해 주세요.";
    private static final String MINIMUM_PURCHASE_PRICE_MSG = "로또는 1000원 단위로 구매할 수 있습니다.";
    private static final int NUMBER_ZERO = 0;

    private Integer lottoCount;

    public void inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PRICE_MSG);
        lottoCount = Integer.valueOf(scanner.next());
    }

    public boolean validateSmallestUnit(Integer inputValue) {
        if (inputValue < 1000 || Math.floorDiv(inputValue, 1000) != 0) {
            System.exit(NUMBER_ZERO);
            throw new IndexOutOfBoundsException(MINIMUM_PURCHASE_PRICE_MSG);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(lottoCount, inputView.lottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
