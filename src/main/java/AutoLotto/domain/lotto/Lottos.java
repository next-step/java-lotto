package AutoLotto.domain.lotto;

import AutoLotto.utils.CheckDivideBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static List<Lotto> buyLottosWith(int budget) {
        int numOfLottos = CheckDivideBy.divideToInt(Integer.toString(budget), "1000");
        List<Lotto> lottoList = new ArrayList<>(numOfLottos);
            for (int i = 0; i < numOfLottos ; i++) {
                lottoList.add(new Lotto());
            }
            return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
