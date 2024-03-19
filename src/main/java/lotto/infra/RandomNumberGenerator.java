package lotto.infra;

import lotto.domain.LottoNumbers;
import lotto.domain.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> possibleNumbers = IntStream.range(LottoNumbers.MIN_NUMBER, LottoNumbers.MAX_NUMBER + 1).boxed().collect(Collectors.toList());

        Collections.shuffle(possibleNumbers);

        return possibleNumbers.subList(0, LottoNumbers.NUMBER_LEN);
    }
}
