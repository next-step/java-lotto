package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        Rank rank = new Rank();
        int money = InputView.purchase();
        List<Lotto> lottos = puchase(money);
        ResultView.purchase(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.winningNumber());
        lottos.forEach(l -> {
            int count = l.matchCount(winningNumbers);
            if(count == 3) {
                rank.thirdCount += 1;
            }
            if(count == 4) {
                rank.thirdCount += 1;
            }
            if(count == 5) {
                rank.secondCount += 1;
            }
            if(count == 6) {
                rank.firstCount += 1;
            }
        });
        ResultView.result(rank,money);

    }

    public static List<Lotto> puchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; ++i) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
        return lottos;
    }
}
