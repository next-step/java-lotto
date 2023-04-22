package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final List<LottoNumber> LOTTO_LOTTO_NUMBER_LIST = IntStream.rangeClosed(
            LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
        .boxed()
        .map(LottoNumber::new)
        .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = sorted(validList(unDuplicate(lottoNumbers)));
    }

    private List<LottoNumber> unDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = Set.copyOf(lottoNumbers);
        List<LottoNumber> ret = new ArrayList<>();
        for (LottoNumber lottoNumber : set) {
            ret.add(lottoNumber);
        }
        return ret;
    }

    public static Lotto nextRandom(List<LottoNumber> lottoNumbers) {
        return new Lotto(sorted(subList(shuffled(lottoNumbers))));
    }

    private static List<LottoNumber> subList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    private static List<LottoNumber> shuffled(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static List<LottoNumber> sorted(List<LottoNumber> result) {
        Collections.sort(result, LottoNumber::compare);
        return result;
    }

    public static Lotto purchase() {
        return nextRandom(LOTTO_LOTTO_NUMBER_LIST);
    }

    private List<LottoNumber> validList(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                "로또는 " + LOTTO_NUMBER_COUNT + "개의 중복되지않은 숫자로만 구성 가능합니다 : " + lottoNumbers.size());
        }
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public List<LottoNumber> numbers() {
        return new ArrayList<>(lottoNumbers);
    }

}
