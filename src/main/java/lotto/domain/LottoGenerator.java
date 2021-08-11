package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 65;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }

    public LottoTicket generate() {
        return new LottoTicket(shuffle());
    }

    private List<LottoNumber> shuffle(){
        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> drawnLottoNumbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, 6));
        Collections.sort(drawnLottoNumbers);
        return drawnLottoNumbers;
    }
}
