package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_BOUNDARY = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_SIZE = 6;

    public int match(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winningLotto.getNumbers().contains(num))
                .count();
    }

    public Rank getRank(int matchCount) {
        return Rank.of(matchCount);
    }

    public int purchaseLotto(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 로또 한 장 값보다 작을 수 없습니다.");
        }
        return price / LOTTO_PRICE;
    }

    public int getTotalWinnings(List<Rank> winningResults) {
        return winningResults.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }

    public double getRateOfRevenue(int price, int totalWinnings) {
        return (double) totalWinnings / price;
    }

    public List<Lotto> createLottos(int purchaseCount) {
        return Stream
                .generate(() -> new Lotto(generateNonDuplicateNumbers()))
                .limit(purchaseCount)
                .collect(toList());
    }

    private List<Integer> generateNonDuplicateNumbers() {
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();
        int number;

        while (numberSet.size() != LOTTO_NUMBER_SIZE) {
            number = random.nextInt(LOTTO_NUMBER_BOUNDARY) + MINIMUM_LOTTO_NUMBER;
            numberSet.add(number);
        }

        List<Integer> numbers = numberSet.stream().collect(toList());
        Collections.shuffle(numbers);

        return numbers;
    }
}
