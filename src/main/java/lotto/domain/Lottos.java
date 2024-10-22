package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> manualNumbers, int autoCount) {
        lottos.addAll(manualNumbers);
        for (int i = 0; i < autoCount; i++) {
            lottos.add(generateAuto());
        }
    }

    private Lotto generateAuto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != Lotto.LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.generateRandomNumber());
        }
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult calculateLottoResult(final WinningNumber winningNumber) {
        return new LottoResult(findLottoRewards(winningNumber));
    }

    private List<LottoRewards> findLottoRewards(final WinningNumber winningNumber) {
        List<LottoRewards> rewards = new ArrayList<>();
        for (Lotto lotto : lottos) {
            rewards.add(winningNumber.findLottoRewards(lotto));
        }
        return rewards;
    }
}
