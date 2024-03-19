package lotto.model;

import lotto.dto.LottoNumberResponse;
import lotto.exception.InvalidLottoException;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        return new Prize(toRanks(winningLotto));
    }

    private List<Rank> toRanks(WinningLotto winningLotto) {
        return this.lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(toList());
    }
}
