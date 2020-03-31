package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto() {
        this(generateAutoLottoSet());
    }

    private Lotto(String lottoString) {
        this(generateManualLottoSet(lottoString));
    }

    private Lotto(Set<LottoNumber> lottos) {
        validateSize(lottos);
        this.lottoNumbers = Collections.unmodifiableSet(lottos);
    }

    public static Lotto autoLotto() {
        return new Lotto();
    }

    public static Lotto manualLotto(String lottoString) {
        return new Lotto(lottoString);
    }

    private static Set<LottoNumber> generateAutoLottoSet() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        while (lottoNumberSet.size() != LOTTO_SIZE) {
            lottoNumberSet.add(LottoNumber.peek());
        }
        return lottoNumberSet;
    }

    private static Set<LottoNumber> generateManualLottoSet(String lottoString) {
        String[] lottoStrings = lottoString.split(DELIMITER);
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        for (String lottoNumber : lottoStrings) {
            lottoNumberSet.add(LottoNumber.valueOf(Integer.parseInt(lottoNumber.trim())));
        }
        return lottoNumberSet;
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> deduplicationLottoNumbers = new HashSet<>(lottoNumbers);
        if (deduplicationLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개를 선택 해야합니다.", LOTTO_SIZE));
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
