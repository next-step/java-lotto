package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final List<Set<Integer>> manualNumbers, final LottoPurchaseInfo lottoPurchaseInfo) {
        for (Set<Integer> manualNumber : manualNumbers) {
            lottos.add(Lotto.from(manualNumber));
        }
        for (int i = 0; i < lottoPurchaseInfo.getAutoCount(); i++) {
            lottos.add(generateAuto());
        }
    }

    private Lotto generateAuto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != Lotto.LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.from());
        }
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
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
