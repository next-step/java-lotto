package lotto.view;

import lotto.domain.Lotto;

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
            return purchaseAmount();
        }
    }

    @Override
    public int manualQuantity(long purchaseAmount) {
        try {
            return inputViewV2.manualQuantity(purchaseAmount);
        } catch (Exception e) {
            return manualQuantity(purchaseAmount);
        }
    }

    @Override
    public List<Lotto> manualNumbers(int manualQuantity) {
        try {
            return inputViewV2.manualNumbers(manualQuantity);
        } catch (Exception e) {
            return manualNumbers(manualQuantity);
        }
    }

    @Override
    public List<Integer> lastWeekWinningNumbers() {
        try {
            return inputViewV2.lastWeekWinningNumbers();
        } catch (Exception e) {
            return lastWeekWinningNumbers();
        }
    }

    @Override
    public int bonusBall() {
        try {
            return inputViewV2.bonusBall();
        } catch (Exception e) {
            return bonusBall();
        }
    }
}
