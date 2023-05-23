package lotto.domain.generaterule;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public interface LottoGenerateRule {
    Lotto generateLotto(List<LottoNumber> lottoNumbers);
}
