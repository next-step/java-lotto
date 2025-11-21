package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.List;
import java.util.Objects;

public class BuyLotto {

    private final List<Lotto> lottos;

    public BuyLotto(Integer... numbers) {
        this(List.of(new Lotto(numbers)));
    }

    public BuyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult match(Lotto winningLotto, NumberElement bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto buyLotto : lottos) {
            lottoResult.putLottoResult(matchCount(buyLotto, winningLotto, bonusNumber));
        }

        return lottoResult;
    }

    private LottoRank matchCount(Lotto buyLotto, Lotto winningLotto, NumberElement bonusNumber) {
        int count = buyLotto.matchCount(winningLotto);

        if (isBonus(count)) {
            return checkBonusNumber(buyLotto, bonusNumber);
        }

        return LottoRank.fromMatchCount(count);
    }

    private static boolean isBonus(int count) {
        return count == 5;
    }

    public LottoRank checkBonusNumber(Lotto buyLotto, NumberElement bonusNumber) {
        if (buyLotto.checkBonusNumber(bonusNumber)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }


    @Override
    public String toString() {
        return "BuyLotto{" +
                "lotto=" + lottos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BuyLotto buyLotto = (BuyLotto) o;
        return Objects.equals(getLottos(), buyLotto.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLottos());
    }


}
