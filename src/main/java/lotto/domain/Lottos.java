package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> elements;

    public Lottos(List<Lotto> elements) {
        this.elements = elements;
    }

    public List<Lotto> getElements() {
        return this.elements;
    }

    public long size() {
        return this.elements.size();
    }

    public static Lottos concat(Lottos targetA, Lottos targetB) {
        return new Lottos(Stream.concat(targetA.elements.stream(), targetB.elements.stream()).collect(Collectors.toList()));
    }

    public Map<WinningGrade, Integer> getWinningStatics(WinningNumbers winningNumbers) {
        Map<WinningGrade, Integer> lotteryStatistics = initStatistics();
        this.elements.forEach(lotto -> {
            WinningGrade winningGrade = winningNumbers.getWinningGrade(lotto);
            lotteryStatistics.put(winningGrade, lotteryStatistics.get(winningGrade) + 1);
        });

        return Collections.unmodifiableMap(lotteryStatistics);
    }

    private Map<WinningGrade, Integer> initStatistics() {
        Map<WinningGrade, Integer> lotteryStatistics = new HashMap<>();
        for (WinningGrade grade : WinningGrade.values()) {
            lotteryStatistics.put(grade, 0);
        }
        return lotteryStatistics;
    }

}
