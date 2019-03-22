package lottogame.inputgetter;

import lottogame.domain.PurchaseAmount;
import lottogame.view.InputView;

public class PurchaseAmountInputGetter implements InputGettable<PurchaseAmount,Object> {

    @Override
    public PurchaseAmount getReturnObject(Object[] object) {
        return new PurchaseAmount(InputView.getInputLine());
    }

    @Override
    public void showInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}