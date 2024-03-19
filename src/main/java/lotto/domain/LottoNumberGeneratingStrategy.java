package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGeneratingStrategy {
    List<Integer> lottoNumbers();
}
