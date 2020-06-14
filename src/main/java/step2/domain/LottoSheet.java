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

    public void drawPrize(WinningLotto winningLotto, Map<Prize, Integer> prizeResult) {

        lottos.stream().forEach(lotto -> {
                Prize prize = lotto.getPrize(winningLotto);
                prizeResult.put(prize, prizeResult.get(prize).intValue() + 1);
            }
        );
    }

    @Override
    public String toString() {
        return "LottoSheet{" +
            "lottos=" + lottos +
            '}';
    }
}
