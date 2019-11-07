package step2.domain.lottomachine;

import step2.domain.LottoNumber;
import step2.domain.LottoTicket;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static step2.domain.LottoNumber.MAX_NUMBER;
import static step2.domain.LottoNumber.MIN_NUMBER;

public abstract class LottoMachine {

    protected static final int ADD_SIZE = 5;
    protected static final List<LottoNumber> lottoNumbers = getInstance();

    private static List<LottoNumber> getInstance() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    public abstract LottoTicket issueLottoTicket(List<Integer> numbers);

}
