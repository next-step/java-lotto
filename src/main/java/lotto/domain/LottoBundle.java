package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    private LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = Collections.unmodifiableList(lottoBundle);
    }

    public static LottoBundle issues(final int lottoBundleCount) {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        final List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoBundleCount; i++) {
            lottoBundle.add(new Lotto(lottoNumbers.shuffleAndPickLottoNumbers()));
        }
        return new LottoBundle(lottoBundle);
    }

    public int size() {
        return lottoBundle.size();
    }
}
