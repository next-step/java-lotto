package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {
    private static List<LottoNumber> lottoNumbersCache;

    static {
        lottoNumbersCache = new ArrayList<>();

        for(int i = LottoNumber.MIN_LOTTO_NUMBER; i<=LottoNumber.MAX_LOTTO_NUMBER; i++) {
            lottoNumbersCache.add(new LottoNumber(i));
        }
    }

    public LottoTicket generate() {
        Collections.shuffle(lottoNumbersCache);

        return new LottoTicket(lottoNumbersCache.subList(0, 6));
    }
}
