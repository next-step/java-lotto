package study.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성 되어야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    private Lotto(List<LottoNumber> lottoNumberList) {
        this(new TreeSet<>(lottoNumberList));
    }

    private Lotto() {
        this(LottoNumber.generateLottoNumbers());
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public static Lotto of(List<LottoNumber> lottoNumberList) {
        return new Lotto(lottoNumberList);
    }

    public static Lotto of(String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public long compareToLotto(Lotto lotto) {
        return lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public String toString() {
        return lottoNumbers
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList())
                .toString();
    }
}
