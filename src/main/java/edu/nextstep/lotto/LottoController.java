package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List lottoList;
    private Lotto lotto;

    LottoController() {
        lottoList = new ArrayList();
        lotto = new Lotto();
    }

    public void setup() {
        ResultView.print("구입금앱을 입력해 주세요");
        int count = ResultView.lottoCount(InputView.inputMoney());

        for (int i = 0; i < count; i++) {
            lottoList.add(lotto.makeLotto());
        }

        ResultView.print("지난 주 당첨 번호를 입력해 주세요.");
        String[] winNumber = InputView.winNumber();

        ResultView.print("당첨 통계");
        ResultView.print("--------");

        for (int i = 0; i < lottoList.size(); i++) {
            ((Lotto)lottoList.get(i)).checkLotto(winNumber);
        }

    }
}
