package lottogame.inputgetter;

import lottogame.domain.LottoNumberPackage;
import lottogame.view.InputView;

public class WinningNumberInputGetter implements InputGettable<LottoNumberPackage, Object> {

    @Override
    public LottoNumberPackage getReturnObject(Object[] parameters) {
        return new LottoNumberPackage(InputView.getInputLine());
    }

    @Override
    public void showInputMessage() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }
}