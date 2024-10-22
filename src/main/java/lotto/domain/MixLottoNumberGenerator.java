package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MixLottoNumberGenerator implements LottoNumberGenerator {
    private LottoCount lottoCount ;

    public MixLottoNumberGenerator(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }


    @Override
    public List<LottoNumbers> generate() {
        List<LottoNumbers> newGeneratedNumbers = new ArrayList<>();
        newGeneratedNumbers.addAll(new ManualLottoNumberGenerator(lottoCount.getManualLottoCount()).generate());
        newGeneratedNumbers.addAll(new AutoLottoNumberGenerator(lottoCount.getAutoLottoCount()).generate());
        return newGeneratedNumbers;
    }
}
