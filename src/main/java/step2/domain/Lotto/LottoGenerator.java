package step2.domain.Lotto;

import step2.dto.LottoCreationRequestDto;
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

    private final LottoGenerateCount lottoGenerateCount;
    private final LottoShuffleStrategy lottoShuffleStrategy;

    public LottoGenerator(LottoCreationRequestDto requestDto, LottoShuffleStrategy lottoShuffleStrategy) {
        this(LottoGenerateCount.newInstance(requestDto), lottoShuffleStrategy);
    }

    private LottoGenerator(LottoGenerateCount lottoGenerateCount) {
        this(lottoGenerateCount, LottoRandomShuffleStrategy.getInstance());
    }

    private LottoGenerator(LottoGenerateCount lottoGenerateCount, LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoGenerateCount = lottoGenerateCount;
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerator newInstance(LottoGenerateCount lottoGenerateCount) {
        return new LottoGenerator(lottoGenerateCount);
    }

    public static final LottoGenerator newInstance(LottoGenerateCount lottoGenerateCount, LottoShuffleStrategy lottoShuffleStrategy) {
        return new LottoGenerator(lottoGenerateCount, lottoShuffleStrategy);
    }

    public static final LottoGenerator newInstance(LottoCreationRequestDto requestDto, LottoShuffleStrategy lottoShuffleStrategy) {
        return new LottoGenerator(requestDto, lottoShuffleStrategy);
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

    public final boolean hasNext() {
        return lottoGenerateCount.hasNext();
    }

    public final void next() {
        lottoGenerateCount.next();
    }

}
