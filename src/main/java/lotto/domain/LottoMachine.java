package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private List<LottoNumber> lottoNumbers;
    private final static int MIN_LOTTO = 1;
    private final static int MAX_LOTTO = 46;
    private final static int FIRST_LOTTO_INDEX = 0;
    private final static int END_LOTTO_INDEX = 6;

    public LottoMachine() {
        lottoNumbers = IntStream
            .range(MIN_LOTTO, MAX_LOTTO)
            .boxed()
            .map(LottoNumber::new)
            .collect(
                Collectors.toList()
            );
    }

    public Ticket generateTicket() {
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(FIRST_LOTTO_INDEX, END_LOTTO_INDEX);
        lottoNumbers.sort(LottoNumber::compareTo);
        return new Ticket(lottoNumbers);
    }

    public WinningNumber generateWinningTicket(String winningNumber) throws IllegalArgumentException {
        return new WinningNumber(new Ticket(Arrays.stream(winningNumber.split(", "))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList())));
    }
}
