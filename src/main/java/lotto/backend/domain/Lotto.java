package lotto.backend.domain;

import lotto.backend.dto.LottoResultDto;

import java.util.Arrays;

public class Lotto {
    private static final String COMMA = ",";
    private LottoTickets lottoTickets;

    public LottoTickets buy(int paidMoney) {
        this.lottoTickets = LottoTicket.of(new Money(paidMoney));
        return lottoTickets;
    }

    public LottoResultDto match(String winningNumber) {
        LottoTicket winningLotto = convertToLottoTicket(winningNumber);
        LottoResult lottoResult = LottoResult.of(winningLotto, lottoTickets);
        return LottoResultDto.from(lottoResult);
    }

    private LottoTicket convertToLottoTicket(String winningNumber) {
        return LottoTicket.of(Arrays.stream(winningNumber.split(COMMA))
                .mapToInt(Integer::parseInt)
                .toArray());
    }
}
