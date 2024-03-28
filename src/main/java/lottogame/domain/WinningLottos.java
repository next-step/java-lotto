package lottogame.domain;

import java.util.List;

public class WinningLottos extends Lottos {

    private final LottoNumber bonusNumber;

    public WinningLottos(List<Integer> numbers,int bonusNumber) {
        super(numbers);
        this.bonusNumber =  new LottoNumber(bonusNumber);
    }

    @Override
    public Rank getRank(Lottos lottos) {
        return Rank.findRank(match(lottos), matchBonusNumber(lottos));
    }

    @Override
    public Number getPrize(Lottos lotto) {
        return Number.from(Rank.findPrize(match(lotto), matchBonusNumber(lotto)));
    }

    private boolean matchBonusNumber(Lottos lottos) {
        return lottos.match(bonusNumber);
    }
}
