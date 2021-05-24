package lottoAuto.view;

import lottoAuto.model.Lotto;
import lottoAuto.model.LottoAuto;
import lottoAuto.model.Lottos;
import lottoAuto.vo.LottoResultVo;

import java.util.*;

public class LottoAutoResultView {
    private LottoAutoInputView lottoAutoInputView = new LottoAutoInputView();

    public int showAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = lottoAutoInputView.inputPrice();
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }

    public void showUserLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public String showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoString = lottoAutoInputView.inputWinningNumber();

        return winningLottoString;
    }

    public int showBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = lottoAutoInputView.inputBonusBall();
        return bonusBall;
    }

    public void showWinningStatistic(List<LottoResultVo> lottoResultVo) {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

}
