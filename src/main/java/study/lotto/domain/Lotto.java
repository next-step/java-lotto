package study.lotto.domain;

import study.lotto.exception.WrongLottoSizeException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String NUMBER_DELIMITER = ", |,";
    public static final int LOTTO_SIZE = 6;

    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new WrongLottoSizeException();
        }
        this.lotto = lotto;
    }


    public Lotto(List<Integer> integersLotto) {
        this(intToMap(integersLotto));
    }

    public Lotto(String stringLotto) {
        this(stringToMap(stringLotto));
    }

    private static Set<LottoNumber> stringToMap(String stringLotto) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (String stringNumber : stringLotto.split(NUMBER_DELIMITER)) {
            lotto.add(LottoNumber.of(stringNumber));
        }
        return lotto;
    }

    private static Set<LottoNumber> intToMap(List<Integer> integersLotto) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : integersLotto) {
            lotto.add(LottoNumber.of(number));
        }
        return lotto;
    }

    public static Lotto randomNumbers() {
        List<Integer> keys = new ArrayList<>(LottoNumber.LOTTO_NUMBER_MAP.keySet());
        Collections.shuffle(keys);

        return new Lotto(keys.stream().limit(LottoGame.MARK_SIZE).map(LottoNumber::of).collect(Collectors.toSet()));
    }

    public List<LottoNumber> lotto() {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lotto);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    public int matchWinningNumberCount(Lotto winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>(winningNumbers.lotto());
        numbers.removeAll(lotto);
        return LottoGame.MARK_SIZE - numbers.size();
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
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

    @Override
    public String toString() {

        return lotto().stream()
                .map(LottoNumber::value).collect(Collectors.toList())
                .toString();
    }
}
