package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private final List<Integer> availableNumbers;

    public LottoTicketMachine() {
        this.availableNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toUnmodifiableList());
    }

    public LottoTicket issue() {
        var lottoNumber = pickNumbers();
        return new LottoTicket(lottoNumber);
    }

    private List<Integer> pickNumbers() {
        return List.of(1,2,3,4,5,6);
    }
}
