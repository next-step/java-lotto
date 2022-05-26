package dev.solar.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

import dev.solar.lotto.LottoException;

public class WinningLotto {
    private final Set<LottoNumber> winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Set<Integer> numbers, final int bonusNumber) {
        if (numbers.size() != LottoTicket.getLottoTicketSize()) {
            throw new LottoException("로또 한장 당 번호는 " + LottoTicket.getLottoTicketSize() + "개여야 합니다.");
        }

        this.winningLotto = numbers.stream()
                                   .map(LottoNumber::new)
                                   .collect(Collectors.toSet());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank match(final LottoTicket lottoTicket) {
        final int countOfMatch = (int) winningLotto.stream()
                                                   .filter(lottoTicket.getLottoNumbers()::contains)
                                                   .count();
        return Rank.rank(countOfMatch, lottoTicket.isContain(bonusNumber));
    }

}
