package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public static List<Lotto> filter(final List<Lotto> lottos, final int matchNumber) {
        return lottos.stream().filter(lotto -> lotto.isMatchPoint(matchNumber)).collect(toList());
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled"})
    public static double getRate(final List<Lotto> lottos, final int lottoPurchaseAmount) {

        final int amountThere = Lottos.filter(lottos, 3).size() * 5000;
        final int amountFour = Lottos.filter(lottos, 4).size() * 50000;
        final int amountFive = Lottos.filter(lottos, 5).size() * 1500000;
        final int amountSix = Lottos.filter(lottos, 6).size() * 2000000000;

        final BigDecimal bigDecimal1 = new BigDecimal(amountThere + amountFour + amountFive + amountSix);
        final BigDecimal bigDecimal2 = new BigDecimal(lottoPurchaseAmount);
        return bigDecimal1.divide(bigDecimal2).doubleValue();
    }

    public void add(final Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
