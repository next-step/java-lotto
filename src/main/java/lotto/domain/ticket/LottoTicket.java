package lotto.domain.ticket;

import lotto.domain.LottoNumber;
import lotto.domain.result.LottoPrize;
import lotto.domain.result.WinningTicket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoGameProperty.COUNT_OF_LOTTO_NUMBER;

public class LottoTicket {
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또번호는 중복이 없는 6개의 1과 45사이의 숫자여야 합니다");
        }
    }

    public LottoPrize calculateLottoPrize(WinningTicket winningTicket) {
        int matchCount = Math.toIntExact(lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count());
        boolean matchBonus = lottoNumbers.stream()
                .anyMatch(winningTicket::matchBonus);

        return LottoPrize.findByMathCount(matchCount, matchBonus);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortedLottoNumbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        return String.valueOf(sortedLottoNumbers);
    }
}
