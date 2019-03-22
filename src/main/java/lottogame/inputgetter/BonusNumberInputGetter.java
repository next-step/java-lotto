package lottogame.inputgetter;

import lottogame.domain.LottoNumberPackage;
import lottogame.domain.WinningInfo;
import lottogame.view.InputView;

public class BonusNumberInputGetter implements InputGettable<WinningInfo, LottoNumberPackage> {

    @Override
    public WinningInfo getReturnObject(LottoNumberPackage... parameters) {
        return new WinningInfo(parameters[0], InputView.getInputLine());
    }

    @Override
    public void showInputMessage() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
    }
}