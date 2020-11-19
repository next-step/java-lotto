package step3.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGeneratorStrategy {

    List<Integer> generateLottoNumbers();
}
