package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicketGenerator {

    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoTicketGenerator() {
        this(new RandomGenerationStrategy());
    }

    public LottoTicketGenerator(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public List<LottoTicket> generateLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = 0; index < ticketCount; index++) {
            lottoTickets.add(generateLottoNumbers());
        }
        return lottoTickets;
    }

    public WinningTicket generateWinningTicket(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        LottoTicket lottoTicket = generateLottoNumbers(numberSet);
        return new WinningTicket(lottoTicket);
    }

    private LottoTicket generateLottoNumbers(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket generateLottoNumbers() {
        return new LottoTicket(numberGenerationStrategy.generateNumbers());
    }

}
