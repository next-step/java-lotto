package lotto.view;

import lotto.model.LottoGroup;
import lotto.model.LottoResult;

public class OutputView {

    public void printLottoCount(int autoCount, int manualCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n" + "---------\n" + lottoResult);
    }

    public void printLotto(LottoGroup lottoGroup) {
        System.out.println(lottoGroup);
    }
}
