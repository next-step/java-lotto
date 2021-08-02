package lotto.domain.service;

import static lotto.domain.model.LottoNumber.*;
import static lotto.domain.model.LottoNumber.BOTTOM_OF_RANGE_INCLUSIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTickets;

public class LottoService {

    private static final List<Integer> ALL_NUMBERS = IntStream.range(
            BOTTOM_OF_RANGE_INCLUSIVE, TOP_OF_RANGE_INCLUSIVE).boxed()
            .collect(Collectors.toList());

    public static LottoTickets createRandomTickets(LottoMoney lottoMoney) {
        int numberOfTickets = lottoMoney.numberOfTickets();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTicket randomTicket = createRandomTicket();
            lottoTickets.add(randomTicket);
        }
        return LottoTickets.createFromTicketList(lottoTickets);
    }

    private static LottoTicket createRandomTicket() {
        Collections.shuffle(ALL_NUMBERS);
        List<Integer> numbers = ALL_NUMBERS.subList(0, LottoTicket.LOTTO_SIZE);
        return LottoTicket.createFromList(numbers);
    }

    public static double profitPercent(LottoResult lottoResult, LottoMoney lottoMoney) {
        int sumMoney = lottoResult.sumWinningMoney();
        int amount = lottoMoney.getAmount();
        return (double) sumMoney / amount;
    }
}
