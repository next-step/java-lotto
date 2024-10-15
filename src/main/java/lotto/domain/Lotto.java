package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNum> lottoNumbers;

    public Lotto(List<LottoNum> lottoNumbers) {
        validateLottoNumber(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this(Arrays.stream(lottoNumbers.split(","))
                .map(LottoNum::new)
                .collect(Collectors.toList()));
    }

    private static void validateLottoNumber(List<LottoNum> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    public List<LottoNum> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int compareWinningNumber(Lotto winner) {
        int result = 0;
        for (LottoNum lottoNumber : lottoNumbers) {
            result += addResult(winner.getLottoNumbers(), lottoNumber);
        }
        return result;
    }

    private static int addResult(List<LottoNum> winner, LottoNum lottoNumber) {
        if (winner.contains(lottoNumber)) {
            return 1;
        }
        return 0;
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

    public boolean isMatchBonus(LottoNum bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
