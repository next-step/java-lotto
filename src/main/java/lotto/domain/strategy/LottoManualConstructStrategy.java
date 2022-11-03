package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.view.InputView;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoManualConstructStrategy implements LottoConstructStrategy {
    @Override
    public List<Lotto> create(int count) {
        return IntStream.rangeClosed(1, count)
            .mapToObj(value -> InputView.getLottoNumbers())
            .map(Lotto::from)
            .collect(toList());
    }
}
