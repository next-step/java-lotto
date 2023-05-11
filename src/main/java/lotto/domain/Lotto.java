package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBERS = Stream.iterate(MIN_LOTTO_NUMBER, n -> n + 1).limit(MAX_LOTTO_NUMBER).collect(Collectors.toList());

    public List<Integer> lotto;

    public Lotto(List<Integer> lottoNumber) {
        ExceptionHandler.validLottoNumberRange(lottoNumber);
        ExceptionHandler.validLottoSize(lottoNumber);
        this.lotto = lottoNumber;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public static Lotto createLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(6)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public static Lotto stringToNumber(String winningLotto) {
        return Arrays.stream(winningLotto.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public int getHitCount(Lotto winningLotto) {
        return winningLotto.lotto.stream()
                .filter(lotto::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "" + lotto;
    }

}
