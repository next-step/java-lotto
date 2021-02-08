package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoMachine implements LottoMachine {

    private final static int MIN_LOTTO = 1;
    private final static int MAX_LOTTO = 45;
    private final static int MIN_LOTTO_COUNT = 0;
    private final static int MAX_LOTTO_COUNT = 6;
    private static int ticketCount;

    public AutoLottoMachine(int lottoCount) {
        this.ticketCount = lottoCount;
    }

    private static List<Integer> createLottoNumbers() {
        return IntStream.range(MIN_LOTTO, MAX_LOTTO + 1).boxed().collect(Collectors.toList());
    }

    public List<Integer> generateAutoTicket() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(MIN_LOTTO_COUNT, MAX_LOTTO_COUNT);
    }

    @Override
    public List<Ticket> buyTicket() {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(generateAutoTicket()));
        }
        return tickets;
    }
}
