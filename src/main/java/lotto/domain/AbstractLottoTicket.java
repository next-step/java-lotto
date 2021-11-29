package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.TicketSizeOutBoundException;

public abstract class AbstractLottoTicket {

    private static final int LOTTO_SIZE = 6;

    protected final Set<LottoNumber> lottoTicket;

    protected AbstractLottoTicket(List<Integer> lottoNumber) {
        Set<LottoNumber> lottoTicket = generateLottoNumber(lottoNumber);
        valid(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void valid(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LOTTO_SIZE) {
            throw new TicketSizeOutBoundException(LOTTO_SIZE);
        }
    }

    private Set<LottoNumber> generateLottoNumber(List<Integer> lottoTicket) {
        return lottoTicket.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toCollection(HashSet::new));
    }

}
