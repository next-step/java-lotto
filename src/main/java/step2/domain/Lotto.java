package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private List<Integer> lottoNumber;
    private int matchesCount = 0;

    public Lotto() {
        lottoNumber = extraction();
    }

    public Lotto(String lotto) {
        this.lottoNumber = Stream.of(lotto.split(","))
                                .map(Integer::parseInt)
                                .sorted()
                                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> lotto, String winner) {
        this.lottoNumber = lotto;
        for (int winnerElement : lastWinner(winner)) {
            increment(winnerElement);
        }
    }

    private void increment(int winnerElement) {
        if (matchLotto(winnerElement)) {
            ++this.matchesCount;
        }
    }

    private boolean matchLotto(int winnerElement) {
        if (lottoNumber.contains(winnerElement)) {
            return true;
        }
        return false;
    }

    private List<Integer> extraction() {
        List<Integer> lotto = new ArrayList<>();
        List<Integer> generateList = generateLotto();

        for (int i = 0; i < 6; i++) {
            lotto.add(generateList.get(i));
        }

        return lotto.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());
    }

    private List<Integer> generateLotto() {
        List<Integer> generateList = new ArrayList<>();

        for (int i = 1; i < 46; i++) {
            generateList.add(i);
        }

        Collections.shuffle(generateList);
        return generateList;
    }

    public List<Integer> lastWinner(String winner) {
        return Stream.of(winner.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public int winnerPrice() {
        System.out.println("match " + getMatchesCount());
        if (matchesCount == 3) {
            return 5000;
        }

        if (matchesCount == 4) {
            return 50000;
        }

        if (matchesCount == 5) {
            return 1500000;
        }

        if (matchesCount == 6) {
            return 200000000;
        }

        return 0;
    }

    public int getMatchesCount() {
        return matchesCount;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
