package lotto.domain;

import java.util.List;

public interface LottoGenerator {

    Lotto createLotto(List<Integer> lottoNumbers);
}
