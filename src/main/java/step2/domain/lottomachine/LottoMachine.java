package step2.domain.lottomachine;

import step2.domain.LottoNumber;
import step2.domain.LottoTicket;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public abstract class LottoMachine {

    protected static final int START_INDEX = 1;
    protected static final int ADD_SIZE = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    protected static final List<LottoNumber> lottoNumbers = getInstance();

    private static List<LottoNumber> getInstance() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    public abstract LottoTicket issueLottoTicket();

}
