package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void generateLottoNumbers(List<Integer> lottoNumber, int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto newLotto = new Lotto(lottoNumber);
            lottos.add(newLotto);
        }
    }

    public void saveMatchResult(WinningLotto winningLotto, Match match) {
        this.lottos.forEach(iter -> {
            winningLotto.saveMatchInfo(iter, match);
        });
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }

    public void generateManualLottoNumbers(ManualLottoGroup manualLottoGroup) {
        List<Lotto> lottos = manualLottoGroup.convertToLottoNumbers();
        this.lottos.addAll(lottos);
    }
}
