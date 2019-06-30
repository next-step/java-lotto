package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPaper {
    private final List<LottoSet> manualLottoSets = new ArrayList<>();
    private final List<LottoSet> autoLottoSets = new ArrayList<>();

    public LottoPaper(List<LottoSet> manualLottoSets, List<LottoSet> autoLottoSets) {
        this.manualLottoSets.addAll(manualLottoSets);
        this.autoLottoSets.addAll(autoLottoSets);
    }

    public LottoPaper(List<LottoSet> lottoSets) {
        this(new ArrayList<>(), lottoSets);
    }

    public int getManualLottoSetsSize() {
        return manualLottoSets.size();
    }

    public int getAutoLottoSetsSize() {
        return autoLottoSets.size();
    }

    public int getLottoSetsSize() {
        return manualLottoSets.size() + autoLottoSets.size();
    }

    public List<LottoSet> getLottoSets() {

        return Stream.concat(manualLottoSets.stream(), autoLottoSets.stream())
                .collect(Collectors.toList());
    }
}
