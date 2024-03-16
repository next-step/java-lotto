package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        if (lottos == null) {
            throw new InvalidLottoException("Null 허용하지 않습니다");
        }

        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public boolean isEmpty() {
        return this.lottos.isEmpty();
    }

    public Map<Integer, Integer> matches(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new InvalidLottoException("유효하지 않은 로또 번호 입니다");
        }

        return this.lottos.stream()
                .map(lotto -> lotto.matches(winningNumbers))
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
