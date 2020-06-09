package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSheet {

    private List<UserLotto> lottos;

    public LottoSheet() {
        this.lottos = new ArrayList<>();
    }

    public LottoSheet(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public void drawPrize(WinningLotto winningLotto, Map<Integer, Integer> prizeResult) {

        lottos.stream().forEach(lotto -> {
                Prize prize = lotto.getPrize(winningLotto);
                prizeResult.put(prize.getGrade(), prizeResult.get(prize.getGrade()).intValue() + 1);
            }
        );
    }
}
