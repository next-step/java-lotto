package lotto.model.lotto;


import lotto.model.lotto.strategy.NumberGenerationStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    public List<LottoTicket> generateLottoTickets(int ticketCount, NumberGenerationStrategy numberGenerationStrategy) {
        return IntStream.range(0, ticketCount)
                .mapToObj(index -> generateLottoTicket(numberGenerationStrategy))
                .collect(Collectors.toList());
    }

    public WinningTicket generateWinningTicket(List<Integer> numbers, LottoNumber bonusNumber) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        LottoTicket lottoTicket = generateLottoTicket(numberSet);
        return new WinningTicket(lottoTicket, bonusNumber);
    }

    private LottoTicket generateLottoTicket(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::create)
                .collect(Collectors.toSet());
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket generateLottoTicket(NumberGenerationStrategy numberGenerationStrategy) {
        return new LottoTicket(numberGenerationStrategy.generateLottoNumbers());
    }

}
