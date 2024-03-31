package lotto;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int numberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos create(Money money, NumberGenerator generator) {
        return generator.generate(countLotto(money));
    }

    private static int countLotto(Money money){
        return money.purchase();
    }

    public LottoResult getWinningResult(Lotto winingLotto, LottoNumber bonus) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winingLotto);
            boolean matchBonus = lotto.matchBonus(bonus);
            result.increaseRankCount(matchCount, matchBonus);
        }
        return result;
    }

    @Override
    public String toString() {
        return "[" +
            lottos +
            ']';
    }
}
