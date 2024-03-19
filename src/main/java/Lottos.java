import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Ranks ranks(Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.rank(winningLotto));
        }
        return new Ranks(ranks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }

    public double rateOfReturn(Lotto winningLotto) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            totalPrize += lotto.rank(winningLotto).prizeMoney(1);
        }
        double result = (double) totalPrize / (this.getLottoCount() * 1000);
        return BigDecimal.valueOf(result).setScale(2, RoundingMode.DOWN).doubleValue();
    }
}
