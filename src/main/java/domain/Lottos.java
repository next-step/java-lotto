package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(Lotto... lottos) {
        this(Arrays.stream(lottos).toList());
    }

    public Lottos(int amount) {
        this(create(amount));
    }


    public Lottos(PurchaseAmount amount) {
        this(generate(amount.ticketCount()));
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    private static List<Lotto> create(int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        int ticketSize = purchaseAmount.ticketCount();
        return generate(ticketSize);
    }

    private static List<Lotto> generate(int ticketSize) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketSize; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }


    public int size() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }


    public List<Rank> checkResult(WinningLotto winningLotto) {
        List<Rank> matches = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            matches.add(winningLotto.match(lotto));
        }
        return matches;
    }
}
