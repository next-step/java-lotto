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

    private static List<Lotto> create(int amount) {
        validateAmount(amount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLotto(amount); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private static int buyLotto(int amount) {
        return amount / 1000;
    }

    private static void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 한다.");
        }
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }


    public List<Integer> checkResult(WinningNumber winningNumber) {
        List<Integer> matches = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.match(winningNumber);
            matches.add(matchCount);
        }
        return matches;
    }
}
