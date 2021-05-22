package step3.domain;

import step3.common.ErrorCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

    public LottoTicket generate(Set<Integer> lottoNumbers) {
        List<LottoNumber> resultNumbers = new ArrayList<>();
        for (int number : lottoNumbers) {
            resultNumbers.add(lottoNumbersCache.get(number));
        }

        return new LottoTicket(resultNumbers);
    }

}
