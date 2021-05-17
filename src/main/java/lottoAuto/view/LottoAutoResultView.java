package lottoAuto.view;

import lottoAuto.vo.LottoResultVo;

import java.util.*;

public class LottoAutoResultView extends LottoAutoInputView {
    public List<List> showMyLottoInformation() {
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice();

        System.out.println(lottoAutoResultService.showAmount() + "개를 구매했습니다.");
        List<List> myLottoNumber = lottoAutoResultService.showLottoNumber();
        for (int i = 0; i < myLottoNumber.size(); i++) {
            System.out.println(myLottoNumber.get(i));
        }
        return myLottoNumber;
    }

    public List<Integer> showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = inputWinningNumber();
        return winningNumber;
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
