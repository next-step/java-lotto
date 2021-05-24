package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumbersGenerator {
    List<LottoNumbers> generate(int count);
}
