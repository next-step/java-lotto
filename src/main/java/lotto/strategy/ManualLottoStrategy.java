package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;

public class ManualLottoStrategy implements LottoStrategy {

    private final List<LottoNumber> lottoNumbers;

    public ManualLottoStrategy(List<LottoNumber> numbers) {
        this.lottoNumbers = numbers;

    }

    public ManualLottoStrategy(LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.getLottoTicket();
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        return lottoNumbers;
    }
}