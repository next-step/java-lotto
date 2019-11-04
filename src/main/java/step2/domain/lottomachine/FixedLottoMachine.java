package step2.domain.lottomachine;

import step2.domain.LottoNumber;
import step2.domain.LottoTicket;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FixedLottoMachine extends LottoMachine {

    private int startIndex;

    public FixedLottoMachine(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public LottoTicket issueLottoTicket() {
        return getSixNumbers();
    }

    private LottoTicket getSixNumbers() {
        List<LottoNumber> numbers = IntStream.rangeClosed(startIndex, startIndex + ADD_SIZE)
                .mapToObj(lottoNumbers::get)
                .collect(toList());
        return new LottoTicket(numbers);
    }
}
