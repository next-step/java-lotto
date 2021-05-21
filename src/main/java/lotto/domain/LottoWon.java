package lotto.domain;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class LottoWon {
    private final Set<LottoNumber> lottoNumbers;

    public LottoWon(Set<LottoNumber> lottoWonNumbers) {
        validate(lottoWonNumbers);

        this.lottoNumbers = new HashSet<>(lottoWonNumbers);
    }

    public LottoRanks match(LottoTickets lottoTickets) {
        return LottoRanks.createByList(lottoTickets.getTickets()
                .stream()
                .map(item -> match(item))
                .collect(Collectors.toList()));
    }

    public LottoRank match(LottoTicket lottoTicket) {
        int countOfMatched = (int) lottoNumbers.stream()
                .filter(number -> lottoTicket.contains(number))
                .count();

        return LottoRank.valueOf(countOfMatched);
    }

    private void validate(Set<LottoNumber> lottoWonNumbers) {
        if (lottoWonNumbers.size() != LottoTicket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또승리는 %d개의 번호를 가져야 합니다.", LottoTicket.LOTTO_NUMBERS_SIZE));
        }
    }
}
