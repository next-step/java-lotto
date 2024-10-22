package lotto.domain.ticket;

import lotto.domain.BonusBall;
import lotto.domain.winning.WinningNumbers;

import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;
    private BonusBall matchedBonus;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int findMatchCount(WinningNumbers winningNumbers) {
        matchedBonus = new BonusBall(matchBonus(winningNumbers));
        return (int) lottoNumbers.stream()
                                 .filter(lottoNumber -> lottoNumber.matchWinningNumbers(winningNumbers))
                                 .count();
    }

    private boolean matchBonus(WinningNumbers winningNumbers) {
        return lottoNumbers.stream()
                           .anyMatch(winningNumbers::matchBonus);
    }

    public boolean getMatchedBonus() {
        return matchedBonus.isMatched();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
