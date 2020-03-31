package lotto.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyer {
    @Getter
    private List<Lotto> lottos;
    private int manualLottoCount;

    public LottoBuyer(int money, List<String> manualLottoValues) {
        this.lottos = LottoStore.sellLotto(money, manualLottoValues);
        this.manualLottoCount = manualLottoValues.size();
    }

    public int getAutoLottoCount() {
        return lottos.size() - this.manualLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }
}
