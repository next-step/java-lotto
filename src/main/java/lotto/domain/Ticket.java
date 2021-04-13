package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public int autoLottoSize() {
        return autoLottos.size();
    }

    public int manualLottoSize() {
        return manualLottos.size();
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        List<Rank> result = new ArrayList<>();
        result.addAll(new ArrayList<>(manualLottos.winningResults(winningNumber)));
        result.addAll(new ArrayList<>(autoLottos.winningResults(winningNumber)));
        return result;
    }

    public Stream<Lotto> autoStream() {
        return this.autoLottos.stream();
    }

    public Stream<Lotto> manualStream() {
        return this.manualLottos.stream();
    }
}


