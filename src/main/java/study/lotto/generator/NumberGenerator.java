package study.lotto.generator;

import study.lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<LottoNumber> generate(String text);
}
