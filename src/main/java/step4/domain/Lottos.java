package step4.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 로또 묶음
 */
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public static Lottos createLottosByCount(int count) {
        return new Lottos(count);
    }

    public static Lottos createLottosByPrice(Amount totalAmount) {
        int count = totalAmount.divideIntoCount(Lotto.defaultPrice());
        return new Lottos(count);
    }

    public int size() {
        return lottos.size();
    }

    public String allLottoNumbersToString() {
        return lottos.stream()
            .map(Lotto::numbersToString)
            .collect(Collectors.joining("\n"));
    }

    public Map<Lotto, MatchResult> createMatchResultMap(LottoNumbers lottoNumbers, Integer bonusNumber) {
        Map<Lotto, MatchResult> matchResultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            matchResultMap.put(lotto, lotto.match(lottoNumbers, bonusNumber));
        }
        return matchResultMap;
    }

    public Amount totalPrice() {
        return lottos.stream()
            .map(Lotto::price)
            .reduce(new Amount(0), Amount::add);
    }
}
