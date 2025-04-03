package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoMachine(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public LottoTickets issueAuto(int purchaseQuantity) {

        if (purchaseQuantity <= 0) {
            throw new IllegalArgumentException("유효하지 않는 구입 장수입니다: " + purchaseQuantity);
        }

        return new LottoTickets(IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> new LottoTicket(numberGenerationStrategy.generateNumbers()))
                .collect(Collectors.toList()));
    }

    public LottoTickets issueManual(List<Set<LottoNumber>> numberSets) {

        List<LottoTicket> tickets = numberSets.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        return new LottoTickets(tickets);
    }

}
