package lottogame.inputgetter;

import lottogame.domain.PurchaseCount;
import lottogame.view.InputView;

public class PurchaseCountInputGetter implements InputGettable<PurchaseCount, Long> {

    @Override
    public PurchaseCount getReturnObject(Long... object) {
        return new PurchaseCount(object[0], InputView.getInputLine());
    }

    @Override
    public void showInputMessage() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }
}