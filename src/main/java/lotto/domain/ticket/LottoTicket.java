package lotto.domain.ticket;

import lotto.domain.BonusNumber;
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

    public LottoTicket(final Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또티켓은 6개의 로또숫자로 이루어져야합니다.");
        }
    }

    public LottoPrize compareWith(final WinningTicket winningTicket) {
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

    public boolean contains(BonusNumber bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getValue() == bonusNumber.getValue());
    }

    @Override
    public String toString() {
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortedLottoNumbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        return String.valueOf(sortedLottoNumbers);
    }
}
