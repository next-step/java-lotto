package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoGenerateStrategy {

    Set<LottoNumber> generateLotto();

}
