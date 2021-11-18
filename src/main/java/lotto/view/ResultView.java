package lotto.view;

import lotto.Bag;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final int money;
    private final Lotto winLotto;

    public ResultView(int money, Lotto winLotto) {
        this.money = money;
        this.winLotto = winLotto;
    }

    public void showLottos(Bag bag) {
        final List<Lotto> lottos = bag.lottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void showStatistics(Bag bag) {
        System.out.println("당첨 통계\n---------");
        final LottoResult lottoResult = bag.lottoResult(winLotto);

        for (Prize prize : Prize.values()) {
            System.out.println(prize.hitCount() + "개 일치" + "(" + prize.money() + "원) - " + lottoResult.result(prize) + "개");
        }
    }

    public void showYield(Bag bag) {
        final LottoResult lottoResult = bag.lottoResult(winLotto);
        final double totalPrize = lottoResult.totalPrize();
        final double yield = totalPrize / money;

        StringBuilder stringBuilder = new StringBuilder()
                .append("총 수익률은 ")
                .append(yield)
                .append("입니다.")
                .append(totalPrize > money ? "(이득)" : "(손해)");

        System.out.println(stringBuilder);
    }
}
