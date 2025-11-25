package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getInputMoney();

        LottoGroup lottoGroup = new LottoGroup(money);

        List<Lotto> lottos = lottoGroup.getLottoNumbers();

        ResultView.showBuyLottos(lottos);

        Lotto winLotto = InputView.getInputWinNumber();

        Map<LottoRank, Integer> map = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }
        for (Lotto lotto : lottos) {
            int cnt = lotto.matchedCount(winLotto);
            LottoRank lottoRank = LottoRank.getLottoRank(cnt);

            if (lottoRank != null) {
                map.put(lottoRank, map.get(lottoRank) + 1);
            }
        }

        ResultView.showStatus(map, money);

    }
}
