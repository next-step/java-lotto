package lotto.model;

import lotto.dto.LottoNumberResponse;
import lotto.exception.InvalidLottoException;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class LottoPaper {
    private final List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        if (lottos == null) {
            throw new InvalidLottoException("Null 허용하지 않습니다");
        }

        this.lottos = lottos;
    }

    public List<LottoNumberResponse> toLottoNumberResponses() {
        return this.lottos.stream()
                .map(Lotto::toLottoNumberResponse)
                .collect(toList());
    }

    public int getQuantity() {
        return this.lottos.size();
    }

    public Prize matches(WinningLotto winningLotto) {
        return new Prize(toRankEnumMap(winningLotto));
    }

    private EnumMap<Rank, Integer> toRankEnumMap(WinningLotto winningLotto) {
        return this.lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(toMap(Function.identity(), e -> 1, Integer::sum, () -> new EnumMap<>(Rank.class)));
    }
}
