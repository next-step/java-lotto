package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.prize.LottoPrize;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalStateException("로또번호들의 값은 항상 있어야합니다");
        }
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoPrize match(WinningLotto winningLotto) {
        return LottoPrize.of(lottoNumbers.match(winningLotto));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }
}
