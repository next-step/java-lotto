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

    public String confirm() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lottos.size(); i++) {
            sb.append(toStringLotto(i)).append("\n");
        }

        return sb.toString();
    }

    public String toStringLotto(int i) {
        if (invalidIndex(i)) {
            throw new InvalidLottoException(String.format("인덱스가 범위를 벗어났습니다: %d개의 로또에서 %d 로또에 접근을 시도했습니다", size(), i));
        }

        return lottos.get(i).toString();
    }

    private boolean invalidIndex(int i) {
        return i < 0 || size() <= i;
    }

    public Map<Integer, Integer> matches(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new InvalidLottoException("유효하지 않은 로또 번호 입니다");
        }

        return this.lottos.stream()
                .map(lotto -> lotto.matches(winningNumbers))
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum));
    }
}
