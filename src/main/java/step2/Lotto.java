package step2;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(int[] givenLottoNumbers) {
        this.lottoNumbers = Arrays.stream(givenLottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
        validateLottoNumberSize(this.lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateLottoNumberSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 한 장은 6장의 숫자가 있어야합니다.");
        }
    }
}
