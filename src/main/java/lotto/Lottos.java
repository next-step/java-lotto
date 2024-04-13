package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(List.of(lottos));
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of() {
        return new Lottos(new ArrayList<>());
    }

    public int numberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void add(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }

    public int size(){
        return this.lottos.size();
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
