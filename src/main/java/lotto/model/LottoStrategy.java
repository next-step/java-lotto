package lotto.model;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    List<Integer> lottoGenerator(List<Integer> lotto);
}
