package study.step2.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {
    List<Integer> getLottoNumbers();
}
