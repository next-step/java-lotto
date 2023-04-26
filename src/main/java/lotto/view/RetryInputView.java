package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;

import java.util.List;

public class RetryInputView implements InputViewV2 {
    private final InputViewV2 inputViewV2;

    public RetryInputView(InputViewV2 inputViewV2) {
        this.inputViewV2 = inputViewV2;
    }

    @Override
    public long purchaseAmount() {
        try {
            return inputViewV2.purchaseAmount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return purchaseAmount();
        }
    }

    @Override
    public int manualQuantity(long purchaseAmount) {
        try {
            return inputViewV2.manualQuantity(purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return manualQuantity(purchaseAmount);
        }
    }

    @Override
    public List<Lotto> manualNumbers(int manualQuantity) {
        try {
            return inputViewV2.manualNumbers(manualQuantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return manualNumbers(manualQuantity);
        }
    }

    @Override
    public List<Integer> lastWeekWinningNumbers() {
        try {
            return inputViewV2.lastWeekWinningNumbers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return lastWeekWinningNumbers();
        }
    }

    @Override
    public Number bonusBall() {
        try {
            return inputViewV2.bonusBall();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return bonusBall();
        }
    }
}
