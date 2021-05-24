package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.List;

public interface LottoGenerator {

    List<Number> numberGenerator();

    void sortNumbers(List<Number> lottoNumbers);

}
