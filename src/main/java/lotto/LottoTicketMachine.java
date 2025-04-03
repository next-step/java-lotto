package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private static final List<Integer> AVAILABLE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toUnmodifiableList());
    private final RandomPicker randomPicker;

    public LottoTicketMachine(Random random) {
        this.randomPicker = new RandomPicker(random);
    }

    public LottoGame issueRandom() {
        var lottoNumbers = randomPicker.pickNumbers(LottoNumbers.DIGIT, AVAILABLE_NUMBERS);
        return new LottoGame(lottoNumbers);
    }
}
