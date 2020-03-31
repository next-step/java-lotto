package lotto.domain;

import java.util.List;

public class LottoManualPublisher implements LottoPublisher{

    private List<LottoNumbers> lottoNumbers;

    public LottoManualPublisher(final List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Lotteries publish() {
        return new Lotteries(lottoNumbers);
    }
}
