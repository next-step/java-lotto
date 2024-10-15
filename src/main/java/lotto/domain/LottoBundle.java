package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle implements Iterable<Lotto> {
    private final List<Lotto> manualLottoBundle;
    private final List<Lotto> autoLottoBundle;

    public LottoBundle(final List<Lotto> manualLottoBundle, final List<Lotto> autoLottoBundle) {
        this.manualLottoBundle = manualLottoBundle;
        this.autoLottoBundle = autoLottoBundle;
    }

    public static LottoBundle createLottoBundle(final LottoBundle manualLottoBundle, final LottoBundle autoLottoBundle) {
        return new LottoBundle(manualLottoBundle.manualLottoBundle, autoLottoBundle.autoLottoBundle);
    }

    public static LottoBundle createAutoLottoBundle(final int lottoBundleCount) {
        final List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoBundleCount; i++) {
            lottoBundle.add(Lotto.createAutoLotto());
        }
        return new LottoBundle(Collections.emptyList(), lottoBundle);
    }

    public static LottoBundle createManualLottoBundle(final List<Lotto> manualLottoBundle) {
        return new LottoBundle(manualLottoBundle, Collections.emptyList());
    }

    public int manualSize() {
        return manualLottoBundle.size();
    }

    public int autoSize() {
        return autoLottoBundle.size();
    }

    public int size() {
        return manualSize() + autoSize();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return Stream.concat(manualLottoBundle.stream(), autoLottoBundle.stream())
            .collect(Collectors.toUnmodifiableList())
            .iterator();
    }
}
