package lotto.model;

import lotto.AutomaticLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoPurchaseTickets sell(final Integer payment) {
        int lottoCount = payment / LOTTO_PRICE;
        List<LottoPurchaseTicket> lottoPurchaseTickets = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoPurchaseTicket.newInstance(AutomaticLottoGenerator.generate()))
                .collect(Collectors.toList());
        return LottoPurchaseTickets.create(lottoPurchaseTickets);
    }
}