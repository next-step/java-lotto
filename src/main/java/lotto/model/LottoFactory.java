package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private static List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)
            .boxed().map(number -> new LottoNumber(number)).collect(Collectors.toList());

    public static LottoTicket createAutoLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.stream()
                .sorted()
                .limit(LOTTO_NUMBER_COUNT_LIMIT)
                .collect(Collectors.toSet()));
    }

}
