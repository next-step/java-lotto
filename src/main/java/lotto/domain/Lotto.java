package lotto.domain;

import lotto.domain.result.Rank;

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
        List<Integer> IntegerList = Arrays.stream(winningLotto.split(", "))
                .map(Integer::parseInt)
                .collect((Collectors.toList()));
        ExceptionHandler.validDuplicatedLottoNumbers(IntegerList);
        return IntegerList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public Rank getRank(Lotto winningLotto, Integer bonusNumber) {
        return Rank.valueOf(winningLotto.lotto.stream()
                .filter(lotto::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum), matchBonus(bonusNumber));
    }

    private boolean matchBonus(Integer bonusNumber) {
        return lotto.stream().anyMatch(number -> number.equals(bonusNumber));
    }

    @Override
    public String toString() {
        return "" + lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
