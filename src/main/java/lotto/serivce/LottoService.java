package lotto.serivce;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

public class LottoService {
    private static final int MIN_LOTTO_COUNT = 1;

    public static LottoTickets buyTickets(int purchaseAmount, List<String> manualLottos) {
        int autoCount = purchaseAmount / LOTTO_PRICE - manualLottos.size();

        if (autoCount < MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException("자동 로또를 생성할 수 없습니다");
        }

        List<LottoTicket> tickets = manualLottos.stream()
                .map(manualLotto -> LottoTicket.ofString(manualLotto))
                .collect(Collectors.toList());

        tickets.addAll(buyTickets(autoCount * LOTTO_PRICE).getLottoTickets());

        return new LottoTickets(tickets);
    }

    public static LottoTickets buyTickets(int inputPrice) {
        Price price = new Price(inputPrice);

        int lottoCount = price.countLotto();

        return new LottoTickets(lottoCount);
    }

    public static Winner match(LottoTickets lottoTickets, String lastWeekWinningInput, LottoNum bonus) {
        int lottoTicketsSize = lottoTickets.size();

        Winner winner = new Winner(lottoTickets, lastWeekWinningInput, bonus);
        return winner.ofProfit(lottoTicketsSize);
    }
}
