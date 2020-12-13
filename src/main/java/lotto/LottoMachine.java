package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final List<LottoNumber> lottoNumbers;

    public LottoMachine() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        lottoNumbersShuffle();
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public LottoTicket generate() {
        return new LottoTicket(lottoNumbers.subList(0,6));
    }
}
