package step2.domain.Lotto;

import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private static final int CREATE_START = 1;
    private static final int CREATE_END = 46;

    private static LottoGenerator instance;
    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoGenerator() {
        this(LottoRandomShuffleStrategy.getInstance());
    }

    private LottoGenerator(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerator getInstance() {
        if(isInstanceNull()) {
            instance = new LottoGenerator();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    public final Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = generateLottoNumbers();
        lottoShuffleStrategy.shuffle(lottoNumbers);
        return Lotto.newInstance(lottoNumbers.subList(FROM_INDEX, TO_INDEX));
    }

    private final List<LottoNumber> generateLottoNumbers() {
        return IntStream.range(CREATE_START, CREATE_END)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

}
