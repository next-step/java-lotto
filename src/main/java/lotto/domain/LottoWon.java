package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class LottoWon {
    private final Set<LottoNumber> lottoNumbers;

    public LottoWon(List<LottoNumber> convertStringToLottoNumberList) {
        this.lottoNumbers = new HashSet<>(convertStringToLottoNumberList);

        if (lottoNumbers.size() != LottoTicket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또승리는 %d개의 번호를 가져야 합니다.", LottoTicket.LOTTO_NUMBERS_SIZE));
        }
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
}
