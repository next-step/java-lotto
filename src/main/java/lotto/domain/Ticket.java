package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Ticket {
    public final Lottos autoLottos;
    public final Lottos manualLottos;

    public Ticket(int purchaseAmount, Lottos manualLottos) {
        this(new Lottos(autoLottoPurchaseAmount(purchaseAmount, manualLottos)), manualLottos);
    }

    public Ticket(Lottos autoLottos, Lottos manualLottos) {
        this.autoLottos = autoLottos;
        this.manualLottos = manualLottos;
    }

    public static int autoLottoPurchaseAmount(int purchaseAmount, Lottos manualLottos) {
        return purchaseAmount - manualLottos.size() * Lotto.lottoPrice();
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        List<Rank> result = new ArrayList<>();
        result.addAll(new ArrayList<>(manualLottos.winningResults(winningNumber)));
        result.addAll(new ArrayList<>(autoLottos.winningResults(winningNumber)));
        return result;
    }

    public <R> R handleLottos(BiFunction<Lottos, Lottos, R> lottosFunction) {
        return lottosFunction.apply(autoLottos, manualLottos);
    }

}


