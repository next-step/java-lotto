package lotto_auto.service;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;
import lotto_auto.util.LottoValidate;

import java.util.*;

public class LottoService {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<Integer> allNumbers;


    public LottoService() {
        allNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public Lotto generateTicket() {
        Collections.shuffle(allNumbers);
        List<Integer> selectedNumbers = allNumbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(selectedNumbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : selectedNumbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }

    public LottoTickets generateTickets(String purchaseAmount) {
        int ticketCount = LottoValidate.ticketCount(purchaseAmount);
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }

        return new LottoTickets(tickets);
    }

}
