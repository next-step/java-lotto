package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static controller.LottoGame.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int totalNumberOfLottos) {
        this.lottos = new ArrayList<>();

        IntStream.range(STARTING_INDEX_LOTTOS, totalNumberOfLottos)
                .forEach(i -> lottos.add(generateLotto()));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int fifthPrize(Lotto winningNumber) {
        return (int) lottos.stream()
                .filter(it -> it.compareWithWinningNumber(winningNumber) == FIFTH_PRIZE_MATCHING_NUMBER)
                .count();
    }

    public int fourthPrize(Lotto winningNumber) {
        return (int) lottos.stream()
                .filter(it -> it.compareWithWinningNumber(winningNumber) == FOURTH_PRIZE_MATCHING_NUMBER)
                .count();
    }

    public int thirdPrize(Lotto winningNumber) {
        return (int) lottos.stream()
                .filter(it -> it.compareWithWinningNumber(winningNumber) == THIRD_PRIZE_MATCHING_NUMBER)
                .count();
    }

    public int firstPrize(Lotto winningNumber) {
        return (int) lottos.stream()
                .filter(it -> it.compareWithWinningNumber(winningNumber) == FIRST_PRIZE_MATCHING_NUMBER)
                .count();
    }

    public double profitRate(Lotto winningNumber) {
        int investment = PRICE_OF_LOTTO * lottos.size();
        int profit = fifthPrize(winningNumber) * FIFTH_PRIZE_REWARD +
                fourthPrize(winningNumber) * FOURTH_PRIZE_REWARD +
                thirdPrize(winningNumber) * THIRD_PRIZE_REWARD +
                firstPrize(winningNumber) * FIRST_PRIZE_REWARD;

        return (double) profit / investment;
    }
}
