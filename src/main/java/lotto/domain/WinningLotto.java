package lotto.domain;

import lotto.domain.type.Rank;
import lotto.dto.WinningLottoDto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto from(WinningLottoDto winningLottoDto) {
        Lotto winningLotto = LottoFactory.createManualLotto(winningLottoDto.winningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(winningLottoDto.bonusNumber());

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    public List<Rank> match(Lottos lottos) {
        return lottos.values()
                .stream()
                .map(this::match)
                .collect(Collectors.toList());
    }

    private Rank match(Lotto lotto) {
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.findRank(matchCount(lotto), matchBonus);
    }

    private int matchCount(Lotto other) {
        return (int) lotto.lottoNumbers()
                .stream()
                .filter(other::contains)
                .count();
    }
}
