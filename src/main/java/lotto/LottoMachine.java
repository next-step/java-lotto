package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private List<Integer> lottoNumberRange;

    public LottoMachine() {
        lottoNumberRange = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(lottoNumberRange::add);
    }

    public List<Integer> makeLottoTicket() {
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.subList(0, 6);
    }

}
