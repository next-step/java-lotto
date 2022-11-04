package lotto.domain;


import lotto.domain.strategy.LottoAutoConstructStrategy;
import lotto.domain.strategy.LottoConstructStrategy;
import lotto.domain.strategy.LottoManualConstructStrategy;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoList {

    private final List<Lotto> autoLottoList;
    private final List<Lotto> manualLottoList;

    private LottoList(List<Lotto> autoLottoList, List<Lotto> manualLottoList) {
        this.autoLottoList = autoLottoList;
        this.manualLottoList = manualLottoList;
    }

    public static LottoList of(int totalCount, int manualCount) {
        return new LottoList(new LottoAutoConstructStrategy().create(totalCount - manualCount)
            , new LottoManualConstructStrategy().create(manualCount));
    }

    public List<Lotto> getLottoList() {
        return Stream.of(autoLottoList, manualLottoList)
            .flatMap(Collection::stream)
            .collect(Collectors.toUnmodifiableList());
    }

    public int getAutoListCount() {
        return autoLottoList.size();
    }

    public int getManualListCount() {
        return manualLottoList.size();
    }
}
