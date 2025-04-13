package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottoNumbers {
    private final List<LottoNumbers> lottoNumbers;
    private final int autoSize;
    private final int slipsSize;

    public PurchasedLottoNumbers(List<LottoNumbers> lottoNumbers, int autoSize, int slipsSize) {
        this.lottoNumbers = lottoNumbers;
        this.autoSize = autoSize;
        this.slipsSize = slipsSize;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", slipsSize, autoSize);
    }
}
