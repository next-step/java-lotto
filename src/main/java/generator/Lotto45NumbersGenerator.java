package generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto45NumbersGenerator implements LottoNumbersGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private static final int PICK_NUMBERS = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = makeLottoNumbers();
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.stream()
                .limit(PICK_NUMBERS)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> makeLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
