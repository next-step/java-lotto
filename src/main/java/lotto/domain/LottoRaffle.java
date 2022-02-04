package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoRaffle {

    private final WinningLotto winningLotto;
    private int match3Number = 0;
    private int match4Number = 0;
    private int match5Number = 0;
    private int matchBonusNumber = 0;
    private int match6Number = 0;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    // TODO : 다중 if 문 enum이나 map을 사용하여 처리
    public void compareLotto(Lotto lotto) {
        int count = lotto.getLotto().stream().reduce(0, (cum, val) -> {
            if (winningLotto.getLotto().contains(val)) {
                return cum + 1;
            }
            return cum;
        });

        if (count == 5 && lotto.getLotto().contains(winningLotto.getBonusNumber())) {
            this.matchBonusNumber++;
            return;
        }

        if (count == 3) {
            this.match3Number++;
            return;
        }

        if (count == 4) {
            this.match4Number++;
            return;
        }

        if (count == 5) {
            this.match5Number++;
            return;
        }

        if (count == 6) {
            this.match6Number++;
            return;
        }
    }

    public List<Integer> getResults() {
        return Arrays.asList(match3Number, match4Number, match5Number, matchBonusNumber,
            match6Number);
    }
}
