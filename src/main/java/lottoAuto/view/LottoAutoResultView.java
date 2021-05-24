package lottoAuto.view;

import lottoAuto.model.Lotto;
import lottoAuto.model.Lottos;
import lottoAuto.vo.LottoResultVo;

import java.util.*;

public class LottoAutoResultView extends LottoAutoInputView {
    public int showAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = inputPrice();
        return amount;
    }

    public Lottos showMyLottoInformation(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
        Lottos userLotto = lottoAutoInputService.inputUserLottoNumber(amount);
        for (Lotto lotto : userLotto.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
        return userLotto;
    }

    public Lotto showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLotto = inputWinningNumber();
        return winningLotto;
    }

    public int showBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = inputBonusBall();
        return bonusBall;
    }

    public void showWinningStatistic(List<LottoResultVo> lottoResultVo) {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

}
