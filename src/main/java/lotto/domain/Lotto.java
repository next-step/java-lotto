package lotto.domain;

import java.util.Set;

class Lotto {
    private Set<LottoNumber> lottoNumbers;

    Lotto(Numbers numbers) {
        lottoNumbers = numbers.generateNumbers();
    }

}
