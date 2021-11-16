package lotto.service;

import lotto.vo.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy {

    List<LottoNumber> generate();
}
