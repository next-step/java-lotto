package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNum> lottoNumbers;

    public Lotto(List<LottoNum> lottoNumbers) {
        validateLottoNumber(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers, String delimiter) {
        this(Arrays.stream(lottoNumbers.split(delimiter))
                .map(LottoNum::new)
                .collect(Collectors.toList()));
    }

    private static void validateLottoNumber(List<LottoNum> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
        Set<LottoNum> set = new HashSet<>(lottoNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("로또는 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<LottoNum> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isContains(LottoNum lottoNum) {
        return lottoNumbers.contains(lottoNum);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) object;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
}
