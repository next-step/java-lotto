package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle implements Iterable<Lotto> {
    private final List<Lotto> lottoBundle;

    public LottoBundle() {
        this.lottoBundle = new ArrayList<>();
    }

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public static LottoBundle mergeAutoAndManualLottoBundle(final LottoBundle manualLottoBundle, final LottoBundle autoLottoBundle) {
        return new LottoBundle(
            Stream.concat(
                manualLottoBundle.lottoBundle.stream(),
                autoLottoBundle.lottoBundle.stream()
            ).collect(Collectors.toUnmodifiableList())
        );
    }

    public static LottoBundle createLottoBundle(final int lottoBundleCount) {
        final List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoBundleCount; i++) {
            lottoBundle.add(Lotto.createAutoLotto());
        }
        return new LottoBundle(lottoBundle);
    }

    public int manualSize() {
        return (int) lottoBundle.stream()
            .filter(Lotto::isManualLotto)
            .count();
    }

    public int autoSize() {
        return (int) lottoBundle.stream()
            .filter(Lotto::isAutoLotto)
            .count();
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
