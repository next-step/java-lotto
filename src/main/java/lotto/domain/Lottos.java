package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lottos {
    private List<LottoNumbers> lottoNumbers;
    private int manualLottoCount;
    private int autoLottoCount;

    public Lottos(List<LottoNumbers> lottoNumbers, int manualLottoCount, int autoLottoCount) {
        this.lottoNumbers = lottoNumbers;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public List<LottoNumbers> lottoNumbers() {
        return lottoNumbers;
    }

    public int manualLottoCount() {
        return manualLottoCount;
    }

    public int autoLottoCount() {
        return autoLottoCount;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoNumbers get(int index) {
        return lottoNumbers.get(index);
    }

    public boolean contains(LottoNumbers numbers) {
        return lottoNumbers.contains(numbers);
    }
}