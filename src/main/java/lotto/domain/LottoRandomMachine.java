package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomMachine implements LottoMachine {

    @Override
    public LottoTicket publish() {
        List<Integer> randomNumbers = shuffleNumbers();

        return new LottoTicket(
            IntStream.range(0, LottoTicket.REQUIRED_NUMBER_SIZE)
                .boxed()
                .map(randomNumbers::get)
                .collect(Collectors.toList()));
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> randomNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }

}
