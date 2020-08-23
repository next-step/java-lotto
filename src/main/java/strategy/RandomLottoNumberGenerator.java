package strategy;

import domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoNumber.MAX_NUMBER_BOUND;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    public static final int LOTTO_NUMBER = 6;

    @Override
    public List<LottoNumber> generator(String input) {
        List<LottoNumber> numberBound = this.getNumberBound();
        Collections.shuffle(numberBound);
        return numberBound.subList(0, LOTTO_NUMBER);
    }

    private List<LottoNumber> getNumberBound() {
        return IntStream.rangeClosed(1, MAX_NUMBER_BOUND)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
