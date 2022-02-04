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

        boolean isBonusNumber = lotto.getLotto().contains(winningLotto.getBonusNumber());
        if(count != 5) {
            isBonusNumber = false;
        }
        LottoResult.upCount(count, isBonusNumber);
    }

    public List<Integer> getResults() {
        return Arrays.asList(
            LottoResult.MATCH3.getCount(),
            LottoResult.MATCH4.getCount(),
            LottoResult.MATCH5.getCount(),
            LottoResult.MATCHBONUS.getCount(),
            LottoResult.MATCH6.getCount()
        );
    }
}
