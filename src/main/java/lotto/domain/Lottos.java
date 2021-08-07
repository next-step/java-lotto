package lotto.domain;

import lotto.strategy.ListSortOrMixStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public Lottos(int ticketNumber, ListSortOrMixStrategy listSortOrMixStrategy) {
        IntStream.range(0, ticketNumber).forEach(idx -> lottos.add(new Lotto(listSortOrMixStrategy)));
    }

    public int size() {
        return lottos.size();
    }

    public void drawLottos(LottoNumbers winnerNumbers) {
        for (Lotto lotto : lottos) {
            lotto.drawLotto(winnerNumbers);
        }
    }

    public long countWinners(Award award) {
        return lottos.stream().filter(lotto -> lotto.isWinner(award)).count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return String.join("\n",
                lottos.stream()
                        .map(lotto -> lotto.toString())
                        .collect(Collectors.toList()));
    }
}
