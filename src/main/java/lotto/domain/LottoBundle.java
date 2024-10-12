package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

public class LottoBundle implements Iterable<Lotto> {
    private final List<Lotto> lottoBundle;

    public LottoBundle() {
        this.lottoBundle = new ArrayList<>();
    }

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public static LottoBundle createLottoBundle(final int lottoBundleCount) {
        final List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoBundleCount; i++) {
            lottoBundle.add(new Lotto(LottoNumber.getNewLottoNumbers(LOTTO_NUMBER_COUNT)));
        }
        return new LottoBundle(lottoBundle);
    }

    public int size() {
        return lottoBundle.size();
    }

    public void add(final Lotto lotto) {
        lottoBundle.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoBundle.iterator();
    }
}
