package study.step2_1.domain;

import java.util.Set;

@FunctionalInterface
public interface LottoNumber {
    Set<Integer> getLottoNumbers();
}
