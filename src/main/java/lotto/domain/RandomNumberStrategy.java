package lotto.domain;

import java.util.List;

public interface RandomNumberStrategy {

    List<LottoNumber> getRandomNumbers(List<LottoNumber> numbers);
}
