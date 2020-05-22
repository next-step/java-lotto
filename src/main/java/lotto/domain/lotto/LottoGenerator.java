package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    protected static final List<LottoNumber> lottoSeed = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::create)
            .collect(Collectors.toList());

    public static LottoTicket create() {
        Collections.shuffle(lottoSeed, new Random());
        return LottoTicket.create(lottoSeed.subList(0, 6));
    }

    public static LottoTicket createManualByIntList(List<Integer> intList) {
        return LottoTicket.create(
                intList.stream()
                        .map(LottoNumber::create)
                        .collect(Collectors.toList())
        );
    }
}
