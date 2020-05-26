package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoNumberSelectRule {
    List<Integer> CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    List<Integer> select();
}
