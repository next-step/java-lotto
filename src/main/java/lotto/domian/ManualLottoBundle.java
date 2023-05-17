package lotto.domian;

import java.util.List;

public class ManualLottoBundle {

    private final List<Lotto> lottoList;

    public ManualLottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> unfoldLottoBundle() {
        return List.copyOf(this.lottoList);
    }

}
