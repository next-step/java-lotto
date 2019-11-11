package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos generatedAuto(int gameCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottos.add(LottoBox.generateLotto());
        }

        return new Lottos(lottos);
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

    public void addAll(List<String> lottoStrings) {
        for (String lottoString : lottoStrings) {
            Lotto lotto = LottoBox.parseNumberString(lottoString);
            lottos.add(lotto);
        }
    }
}
