package step2.domain.lottomachine;

import step2.domain.LottoNumber;
import step2.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoMachine extends LottoMachine {
    private static final int START_INDEX = 0;

    @Override
    public LottoTicket issueLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return getSixNumbers();
    }

    private LottoTicket getSixNumbers() {
        List<LottoNumber> numbers = IntStream.rangeClosed(START_INDEX, START_INDEX + ADD_SIZE)
                .mapToObj(lottoNumbers::get)
                .collect(toList());
        return new LottoTicket(numbers);
    }

}
