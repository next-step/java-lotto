package lotto_second.service;

import lotto_second.domain.Lotto;
import lotto_second.domain.LottoNumber;
import lotto_second.domain.LottoTickets;
import lotto_second.util.LottoValidate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public LottoTickets generateAutoTickets(Integer autoTicketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < autoTicketCount; i++) {
            tickets.add(generateTicket());
        }

        return new LottoTickets(tickets);
    }

    public LottoTickets parseManualTickets(List<String> manualInputTicket) {
        List<Lotto> lottoTickets = manualInputTicket.stream()
                .map(this::parseManualTicket)
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    private Lotto parseManualTicket(String input) {
        Set<LottoNumber> lottoNumbers = LottoValidate.parseLottoNumbers(input);
        LottoValidate.validateLottoNumbers(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers));
    }
}
