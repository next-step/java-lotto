package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final List<Integer> lottoNumbers;
    private int ticketCount;

    public LottoMachine(int ticketCount) {
        this.ticketCount = ticketCount;
        this.lottoNumbers = new ArrayList<>();
        initializeLottoNumbers();
    }

    private void initializeLottoNumbers() {
        int minimumLottoNumber = 1;
        int maximumLottoNumber = 45;
        IntStream.rangeClosed(minimumLottoNumber, maximumLottoNumber)
                .forEach(lottoNumbers::add);
    }

    public List<LottoTicket> issueTickets() {
        return IntStream.range(0, ticketCount)
                .mapToObj(number -> issueTicket())
                .collect(Collectors.toList());
    }

    private LottoTicket issueTicket() {
        Collections.shuffle(this.lottoNumbers);
        List<Integer> sixNumbers = new ArrayList<>(this.lottoNumbers.subList(0, 6));
        Collections.sort(sixNumbers);

        return new LottoTicket(sixNumbers);
    }
}
