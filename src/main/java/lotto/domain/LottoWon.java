package lotto.domain;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class LottoWon {
    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWon(Set<LottoNumber> lottoWonNumbers, LottoNumber bonusNumber) {
        validate(lottoWonNumbers, bonusNumber);

        this.lottoNumbers = new HashSet<>(lottoWonNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoRanks match(LottoTickets lottoTickets) {
        return LottoRanks.createByList(lottoTickets.getTickets()
                .stream()
                .map(item -> match(item))
                .collect(Collectors.toList()));
    }

    public LottoRank match(LottoTicket lottoTicket) {
        boolean bonusMatched = lottoTicket.contains(bonusNumber);
        int countOfMatched = (int) lottoNumbers.stream()
                .filter(number -> lottoTicket.contains(number))
                .count();

        return LottoRank.valueOf(countOfMatched, bonusMatched);
    }

    private void validate(Set<LottoNumber> lottoWonNumbers, LottoNumber lottoNumber) {
        if (lottoWonNumbers.size() != LottoTicket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또승리는 %d개의 번호를 가져야 합니다.", LottoTicket.LOTTO_NUMBERS_SIZE));
        } else if (lottoWonNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또번호에는 보너스번호가 중첩으로 있어서는 안됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWon lottoWon = (LottoWon) o;
        return Objects.equals(lottoNumbers, lottoWon.lottoNumbers) && Objects.equals(bonusNumber, lottoWon.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}
