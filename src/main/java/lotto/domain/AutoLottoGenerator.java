package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static lotto.domain.LottoStore.ZERO;

public class AutoLottoGenerator implements LottoGenerator {
    private final int issueCount;

    public AutoLottoGenerator(int issueCount) {
        this.issueCount = issueCount;
    }

    @Override
    public Lottos generate() {
        return IntStream.range(ZERO, issueCount)
                .mapToObj(lotto -> this.generateAutoNumbers())
                .collect(collectingAndThen(toList(), Lottos::of));
    }

    private Lotto generateAutoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumber.findLottoNumberValues();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .collect(collectingAndThen(toSet(), Lotto::of));
    }
}
