package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.ArrayList;
import java.util.List;

public interface LottoNumbersGenerator {
    List<Number> numbers = new ArrayList<>();

    List<Number> generateNumber();

    void sortNumbers(List<Number> lottoNumbers);
}
