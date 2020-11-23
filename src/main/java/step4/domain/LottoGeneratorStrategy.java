package step4.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGeneratorStrategy {

    List<Integer> generateLottoNumbers();
}
