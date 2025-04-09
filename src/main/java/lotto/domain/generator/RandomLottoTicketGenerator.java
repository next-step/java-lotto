package lotto.domain.generator;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConstants.*;

public class RandomLottoTicketGenerator implements LottoTicketGenerator {
    private static final List<LottoNumber> CACHED_NUMBERS = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            CACHED_NUMBERS.add(new LottoNumber(i));
        }
    }

    @Override
    public LottoTicket generate()  {
        List<LottoNumber> allNumbers = new ArrayList<>(CACHED_NUMBERS);
        Collections.shuffle(allNumbers);
        List<LottoNumber> lottoNumbers = allNumbers.subList(0, LOTTO_NUMBER_COUNT);
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }
}
