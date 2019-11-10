package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private List<Lotto> lottos;

    private UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static UserLotto of(List<Lotto> lottos) {
        return new UserLotto(lottos);
    }

    public static UserLotto generatedAuto(int gameCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottos.add(LottoBox.generateLotto());
        }

        return new UserLotto(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> unmodifiableLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult result(WinningLotto winningLotto, int money) {
        LottoResult lottoResult = new LottoResult(money);
        for (Lotto lotto : lottos) {
            lottoResult.update(winningLotto.match(lotto));
        }

        return lottoResult;
    }
}
