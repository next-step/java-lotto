package lotto.domain.service;

import static lotto.domain.model.LottoNumber.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTickets;
import lotto.dto.LottoResult;

public class LottoService {

    private LottoService() {
    }

    private static final List<LottoNumber> ALL_NUMBERS =
            IntStream.range(MAX_INCLUSIVE, MIN_INCLUSIVE)
                    .boxed()
                    .map(LottoNumber::of)
                    .collect(Collectors.toList());

    public static LottoTickets generateRandomTickets(int numberOfTickets) {
        List<LottoTicket> lottoTickets = IntStream.range(0, numberOfTickets)
                .mapToObj(i -> generateRandomTicket())
                .collect(Collectors.toList());
        return LottoTickets.of(lottoTickets);
    }

    private static LottoTicket generateRandomTicket() {
        Collections.shuffle(ALL_NUMBERS);
        List<LottoNumber> lottoNumbers = ALL_NUMBERS.subList(0, LottoTicket.LOTTO_SIZE);
        return LottoTicket.of(lottoNumbers);
    }

    public static double profitMargin(LottoResult lottoResult, LottoMoney lottoMoney) {
        int totalPrizeMoney = lottoResult.totalPrizeMoney();
        int amountPaid = lottoMoney.getAmount();
        return (double) totalPrizeMoney / amountPaid;
    }
}
