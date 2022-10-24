package step2.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketsFactory {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final NumbersGenerator numbersGenerator;

    public LottoTicketsFactory(int purchaseAmount, NumbersGenerator numbersGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.numbersGenerator = numbersGenerator;
    }

    public LottoTickets lottoTickets() {
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;
        return new LottoTickets(numberAsLottoTickets(numberOfTickets));
    }

    private List<LottoTicket> numberAsLottoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(numberOfTicket -> LottoTicket.from(numbersGenerator))
                .collect(Collectors.toUnmodifiableList());
    }

}
