package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.List;

public interface LottoGenerator {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int LOTTO_FULL_NUMBER = 6;

    List<Number> numberGenerator();

    void sortNumbers(List<Number> lottoNumbers);

}
