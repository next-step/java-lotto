package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoMachine lottoMachine;

    public LottoList(int buyCount) {
        lottoMachine = new LottoMachine();
        for (int i = 0; i < buyCount; i++) {
            // 자동/수동로또을 입력 받을 수 있게 수정이 필요!
            lottoList.add(lottoMachine.getAutoLotto());
        }
    }

    public WinningStatistics getWinning() {
    return null;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void getManualLotto(String manualLottoStr) {
        lottoList.add(lottoMachine.getManualLotto(manualLottoStr));
    }
}
