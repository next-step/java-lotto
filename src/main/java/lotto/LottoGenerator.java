package lotto;

import java.util.List;

public interface LottoGenerator {

    List<Number> numberGenerator();

    void sortNumbers(List<Number> lottoNumbers);

}
