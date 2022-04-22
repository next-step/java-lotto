package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoTicketGenerator() {
        this(new RandomGenerationStrategy());
    }

    public LottoTicketGenerator(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public List<LottoTicket> generateLottoTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(index -> generateLottoNumbers())
                .collect(Collectors.toList());
    }

    public WinningTicket generateWinningTicket(List<Integer> numbers, LottoNumber bonusNumber) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        LottoTicket lottoTicket = generateLottoNumbers(numberSet);
        return new WinningTicket(lottoTicket, bonusNumber);
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
