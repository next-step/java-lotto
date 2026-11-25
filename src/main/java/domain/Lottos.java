package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(int amount) {
        this(create(amount));
    }

    public Lottos(PurchaseAmount amount) {
        this(generate(amount.ticketCount()));
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


    public List<Integer> checkResult(Lotto winningLotto) {
        List<Integer> matches = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.match(winningLotto);
            matches.add(matchCount);
        }
        return matches;
    }
}
