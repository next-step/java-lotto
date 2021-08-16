package step4.domain.lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Lotto lotto) {
        this.lottos = new ArrayList<>();
        this.lottos.add(lotto);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(List<Lotto> manualLotto, List<Lotto> randomLotto) {
        manualLotto.addAll(randomLotto);
        this.lottos = new ArrayList<>(manualLotto);
    }

    public LottoMatch match(WinOfLotto winOfLotto) {
        Map<LottoRank, Integer> lottoMap = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            int correctCount = winOfLotto.correctCount(lotto.numbers());
            boolean hasBonusNumber = winOfLotto.hasBonusNumber(lotto);
            LottoRank lottoNumber = LottoRank.find(correctCount, hasBonusNumber);

            lottoMap.put(lottoNumber, lottoMap.getOrDefault(lottoNumber, 0) + 1);
        }

        return new LottoMatch(lottoMap);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos merge(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
        return new Lottos(lottos);
    }

}
