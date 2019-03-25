package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int FIRST_INDEX = 0;

    @Override
    public Lotto generate() {
        return new Lotto(getSortedLottoNumbers());
    }

    public static LottoBundle generateLottoBundle(long numberOfLottos) {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();

        List<Lotto> autoLottos = LongStream.range(FIRST_INDEX, numberOfLottos)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(autoLottos);
    }

    private List<LottoNumber> getSortedLottoNumbers() {
        List<LottoNumber> lottoNumbers = getUnsortedLottoNumbers();
        sort(lottoNumbers);

        return lottoNumbers;
    }

    private void sort(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }

    private List<LottoNumber> getUnsortedLottoNumbers() {
        return getShuffledAllLottoNumbers().subList(FIRST_INDEX, Lotto.LOTTO_NUMBERS_SIZE);
    }

    List<LottoNumber> getAllLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> getShuffledAllLottoNumbers() {
        List<LottoNumber> allLottoNumbers = getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers;
    }
}
