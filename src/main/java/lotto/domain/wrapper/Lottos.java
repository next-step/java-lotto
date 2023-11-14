package lotto.domain.wrapper;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Numbers> numberses) {
        numberses.forEach(numbers -> lottos.add(new Lotto(numbers)));
    }

    public Map<Integer, Long> countByMatchingNumGroup(Numbers winningNumbers) {
        return lottos.stream()
            .map(lotto -> lotto.countMatchingNumbers(winningNumbers))
            .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    }
}
