package lotto.model;

import lotto.dto.LottoNumberDto;
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

    public List<LottoNumberDto> toLottoNumberDtos() {
        return this.lottos.stream()
                .map(Lotto::toLottoNumberDto)
                .collect(toList());
    }

    public int getQuantity() {
        return this.lottos.size();
    }

    public Prize matches(WinningInfo winningInfo) {
        return new Prize(toRankEnumMap(winningInfo));
    }

    private EnumMap<Rank, Integer> toRankEnumMap(WinningInfo winningInfo) {
        return this.lottos.stream()
                .map(lotto -> lotto.match(winningInfo))
                .collect(toMap(Function.identity(), e -> 1, Integer::sum, () -> new EnumMap<>(Rank.class)));
    }
}
