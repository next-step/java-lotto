package lotto.domain;

import lotto.exception.LottoExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicketMaker.DEFAULT_LOTTO_NUMBER_COUNT;

public class LottoTicket {
    private List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }

        return new LottoTicket(lottoNumbers);
    }

    public long getMatchCountWith(List<LottoNumber> winningLottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public boolean getMatchWith(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
