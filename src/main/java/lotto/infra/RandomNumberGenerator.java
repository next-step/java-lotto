package lotto.infra;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> possibleNumbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(possibleNumbers);

        List<Integer> generatedNumbers = possibleNumbers.subList(0, LottoNumbers.NUMBER_LEN);
        Collections.sort(generatedNumbers);

        return generatedNumbers;
    }
}
