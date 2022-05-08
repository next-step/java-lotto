package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lottos() {

    }

    public void createLotto() {
        Lotto lotto = new Lotto();
        lottos.add(lotto);
    }

    public void printLottoList() {
        lottos.stream()
                .forEach(System.out::println);
    }

    public List<Rank> getWinningList(List<Integer> winningNumbers) {
        return lottos.stream()
                .map(lotto -> Rank.of(lotto.matchCount(winningNumbers)))
                .collect(Collectors.toList());
    }
}
