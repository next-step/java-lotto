package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_PICKUP = 6;
    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(String lotto) {
        return Lotto.of(LottoNumbers.of(lotto));
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of() {
        return of(new NormalShuffleStrategy());
    }

    public static Lotto of(ShuffleStrategy shuffleStrategy) {
        List<Integer> baseNumbers = makeBaseNumbers();
        shuffleStrategy.shuffle(baseNumbers);
        return of(LottoNumbers.of(pickupNumbers(baseNumbers)));
    }

    public LottoNumbers numbers() {
        return lottoNumbers;
    }

    private static List<Integer> makeBaseNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> pickupNumbers(List<Integer> baseNumbers) {
        List<Integer> results = baseNumbers.subList(0, NUMBER_OF_PICKUP);
        Collections.sort(results);
        return results;
    }

    public Winning winning(WinningNumbers winningNumbers) {
        return Winning
            .findByMatchedCount(numberOfMatchedWinningNumber(winningNumbers), matchedBonusNumber(winningNumbers));
    }

    private int numberOfMatchedWinningNumber(WinningNumbers winningNumbers) {
        return winningNumbers.matchedCount(lottoNumbers);
    }

    private boolean matchedBonusNumber(WinningNumbers winningNumbers) {
        return winningNumbers.matchedBonusNumber(lottoNumbers);
    }

    public long prize(WinningNumbers winningNumbers) {
        return winning(winningNumbers).amount();
    }
}
