package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());
    private final List<List<Integer>> lotteryTickets = new ArrayList<>();

    public LottoGame(int purchaseAmount) {
        int numberOfLotto = getNumberOfLotto(purchaseAmount);
        for (int i = 0; i < numberOfLotto; i++) {
            lotteryTickets.add(generateNumber());
        }
    }

    private static int getNumberOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Integer> generateNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> generatedNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(generatedNumbers);
        return generatedNumbers;
    }

    public List<List<Integer>> getLotteryTickets() {
        return lotteryTickets;
    }
}
