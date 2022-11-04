package lotto.domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final int PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int number) {
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto());
        }
    }
    public LottoResults getResults(WinningLotto winningLotto) {
        return new LottoResults(lottos.stream()
                .map(lotto -> winningLotto.getResult(lotto))
                .collect(Collectors.toList()));
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public static Lottos buyLottos(int money) {
        if (money < PRICE) {
            throw new InvalidParameterException("1000 원 이하면 게임이 불가능합니다.");
        }
        return new Lottos(money / PRICE);
    }
}
