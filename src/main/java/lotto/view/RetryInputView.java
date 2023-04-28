package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class RetryInputView implements InputView {
    private final InputView inputView;

    public RetryInputView(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public long purchaseAmount() {
        try {
            return inputView.purchaseAmount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return purchaseAmount();
        }
    }

    @Override
    public int manualQuantity(long purchaseAmount) {
        try {
            return inputView.manualQuantity(purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return manualQuantity(purchaseAmount);
        }
    }

    @Override
    public List<Lotto> manualNumbers(int manualQuantity) {
        try {
            return inputView.manualNumbers(manualQuantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return manualNumbers(manualQuantity);
        }
    }

    @Override
    public List<Integer> lastWeekWinningNumbers() {
        try {
            return inputView.lastWeekWinningNumbers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return lastWeekWinningNumbers();
        }
    }

    @Override
    public LottoNumber bonusBall() {
        try {
            return inputView.bonusBall();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return bonusBall();
        }
    }
}
