package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoPaper {
    private final List<Lotto> userLottos;

    public LottoPaper(List<Lotto> automaticLottos, List<Lotto> manualLottos) {
        if (automaticLottos == null) {
            throw new InvalidLottoException("자동 구매 로또에 null이나 빈 값은 허용하지 않습니다");
        }

        if (manualLottos == null) {
            throw new InvalidLottoException("수동 구매 로또에 null은 허용하지 않습니다");
        }

        this.userLottos = merge(manualLottos, automaticLottos);
    }

    public List<List<String>> mapToList() {
        return this.userLottos.stream()
                .map(Lotto::mapToList)
                .collect(toList());
    }

    public Prize matches(WinningLotto winningLotto) {
        return new Prize(toRanks(winningLotto));
    }

    private List<Rank> toRanks(WinningLotto winningLotto) {
        return this.userLottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(toList());
    }

    private List<Lotto> merge(List<Lotto> manualLottos, List<Lotto> automaticLottos) {
        return Stream.concat(manualLottos.stream(), automaticLottos.stream())
                .collect(toList());
    }

    public int getQuantityTotal() {
        return this.userLottos.size();
    }

}
