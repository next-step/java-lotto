package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoPaper {
    private final List<Lotto> automaticLottos;
    private final List<Lotto> manualLottos;

    public LottoPaper(List<Lotto> automaticLottos, List<Lotto> manualLottos) {
        if (automaticLottos == null) {
            throw new InvalidLottoException("자동 구매 로또에 null이나 빈 값은 허용하지 않습니다");
        }

        if (manualLottos == null) {
            throw new InvalidLottoException("수동 구매 로또에 null은 허용하지 않습니다");
        }

        this.automaticLottos = automaticLottos;
        this.manualLottos = manualLottos;
    }

    public List<List<String>> mapToList() {
        return merge().stream()
                .map(Lotto::mapToList)
                .collect(toList());
    }

    public Prize matches(WinningLotto winningLotto) {
        return new Prize(toRanks(winningLotto));
    }

    private List<Rank> toRanks(WinningLotto winningLotto) {
        return merge().stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(toList());
    }

    private List<Lotto> merge() {
        return Stream.concat(this.manualLottos.stream(), this.automaticLottos.stream())
                .collect(toList());
    }

    public int getAutomaticQuantity() {
        return this.automaticLottos.size();
    }

    public int getManualQuantity() {
        return this.manualLottos.size();
    }

    public int getQuantityTotal() {
        return this.automaticLottos.size() + this.manualLottos.size();
    }

}
