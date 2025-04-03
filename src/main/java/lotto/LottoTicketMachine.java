package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private final List<Integer> availableNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toUnmodifiableList());
    private final RandomPicker randomPicker;

    public LottoTicketMachine(Random random) {
        this.randomPicker = new RandomPicker(random);
    }

    public LottoGame issue() {
        var lottoNumber = randomPicker.pickNumbers(LottoNumbers.DIGIT, availableNumbers);
        return new LottoGame(lottoNumber);
    }
}
