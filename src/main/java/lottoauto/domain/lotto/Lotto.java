package lottoauto.domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }

        Set<LottoNumber> lottoNumberSet = lottoNumbers.stream().map(LottoNumber::of)
                .collect(Collectors.toSet());

        checkDuplicatedNumber(lottoNumberSet);

        this.lottoNumbers = lottoNumberSet;
    }

    private void checkDuplicatedNumber(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 6개의 숫자여야 합니다.");
        }
    }

    public int getLottoScore(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
