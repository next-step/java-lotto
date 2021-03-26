package step2.domain.Lotto;

import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 46;

    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoGenerator() {
        this(LottoRandomShuffleStrategy.getInstance());
    }

    private LottoGenerator(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerator newInstance() {
        return new LottoGenerator();
    }

    public static final LottoGenerator newInstance(LottoShuffleStrategy lottoShuffleStrategy) {
        return new LottoGenerator(lottoShuffleStrategy);
    }

    public final Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = generateLottoNumbers();
        lottoShuffleStrategy.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        Collections.sort(lottoNumbers);
        return Lotto.newInstance(lottoNumbers);
    }

    private final List<LottoNumber> generateLottoNumbers() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

}
