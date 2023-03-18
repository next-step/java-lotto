package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(int ... numbers) {
        this.lottoNumbers = Arrays.stream(numbers).mapToObj(LottoNumber::from).collect(Collectors.toSet());
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자의 갯수는 " + LOTTO_NUMBER_COUNT + "개입니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        Set<LottoNumber> matchCheckSet = new HashSet<>(lotto.lottoNumbers);
        matchCheckSet.retainAll(this.lottoNumbers);
        return matchCheckSet.size();
    }

    public boolean isContains(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    public int getLottoNumbersCount() {
        return lottoNumbers.size();
    }


    public static Lotto lottery() {
        List<Integer> lottoNumberList = Arrays.stream(IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).toArray()).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);
        return new Lotto(lottoNumberList.subList(0, LOTTO_NUMBER_COUNT).stream().mapToInt(i -> i).toArray());
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
