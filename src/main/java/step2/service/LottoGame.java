package step2.service;

import step2.domain.*;
import step2.exception.NotEnoughMoneyException;
import step2.exception.NotInstanceException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private static final List<Integer> NUMBERS = new ArrayList<>();
    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_PURCHASE_PRICE = 1000;

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; ++i) {
            NUMBERS.add(i);
        }
    }

    private LottoGame() {
        throw new NotInstanceException();
    }

    public static LottoTickets generateLotto(Money amount) {
        enoughMoneyOrElseThrow(amount);

        long purchasedLottoCount = amount.dividedAmount(LOTTO_PURCHASE_PRICE);

        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (purchasedLottoCount > 0) {
            lottoTickets.add(new LottoTicket(shuffleNumbers()));

            purchasedLottoCount -= 1;
        }

        return new LottoTickets(lottoTickets);
    }

    private static Set<LottoNumber> shuffleNumbers() {
        Collections.shuffle(NUMBERS);

        return NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .sorted(Integer::compareTo)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void enoughMoneyOrElseThrow(Money amount) {
        if (amount.lessThanPrice(LOTTO_PURCHASE_PRICE)) {
            throw new NotEnoughMoneyException(amount.getAmount());
        }
    }

}
