package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE = 6;
    public static final int PRICE = 1000;

    private final List<LottoNumber> value;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateDistinct(lottoNumbers);
        validateSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.value = lottoNumbers;
    }

    public Lotto(String[] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(a -> new LottoNumber(Integer.parseInt(a)))
                .collect(Collectors.toList()));

    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다. 현재 입력된 숫자는 " + lottoNumbers.size() + "입니다.");
        }
    }

    private void validateDistinct(List<LottoNumber> lottoNumbers) {

        HashSet<LottoNumber> collect = new HashSet<>(lottoNumbers);

        if (collect.size() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또에 중복값이 입력되었습니다.");
        }
    }

    public List<LottoNumber> getValue() {
        return Collections.unmodifiableList(value);
    }

    public int numberOfEquals(Lotto lotto) {
        return (int) this.value.stream().filter(lotto.value::contains).count();
    }

}
