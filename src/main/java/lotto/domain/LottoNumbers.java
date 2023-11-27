package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoNumbers {
    List<Integer> lottoNumbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    List<Integer> lottoNumbers();
}
