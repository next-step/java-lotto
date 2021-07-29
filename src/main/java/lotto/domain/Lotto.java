package lotto.domain;

import java.util.List;

class Lotto {
    private List<LottoNumber> lottoNumbers;

    Lotto(Numbers numbers) {
        lottoNumbers = numbers.generateNumbers();
    }

}
