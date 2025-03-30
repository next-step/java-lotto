package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final LottoNumbersCondition lottoNumbersCondition;
    private final List<Integer> lottoNumbers;

    public LottoMachine(LottoNumbersCondition lottoNumbersCondition) {
        this.lottoNumbersCondition = lottoNumbersCondition;
        this.lottoNumbers = IntStream.range(lottoNumbersCondition.getMinLottoNumber(), lottoNumbersCondition.getMaxLottoNumber() + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public LottoNumbers generateLottoNumber() {
        ArrayList<Integer> numbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(numbers);

        return new LottoNumbers(lottoNumbersCondition, numbers.stream()
                .limit(lottoNumbersCondition.getLottoNumberSize())
                .collect(Collectors.toSet())
        );
    }
}
