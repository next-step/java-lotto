package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void view(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            List<Integer> integers = lotto.lottoNumbers()
                    .stream()
                    .map(value -> value.intValue())
                    .collect(Collectors.toList());
            System.out.println(integers);
        });

    }
}
