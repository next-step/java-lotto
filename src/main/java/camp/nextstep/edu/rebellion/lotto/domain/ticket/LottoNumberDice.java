package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberDice {
    private static final List<Integer> candidateNumbers = new ArrayList<>();

    static {
         IntStream
                .rangeClosed(LottoGameRule.getLottoNumberMin(), LottoGameRule.getLottoNumberMax())
                .forEach(i -> candidateNumbers.add(i));
    }

    public static List<Integer> roll() {
        Collections.shuffle(candidateNumbers);
        return candidateNumbers
                .stream()
                .limit(LottoGameRule.getLottoCount())
                .sorted()
                .collect(Collectors.toList());
    }
}
