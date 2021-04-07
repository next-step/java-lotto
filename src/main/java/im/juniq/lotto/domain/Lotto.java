package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_PICKUP = 6;
    private final LottoNumbers lottoNumbers;
    private final LottoType lottoType;

    private Lotto(LottoNumbers lottoNumbers, LottoType lottoType) {
        this.lottoNumbers = lottoNumbers;
        this.lottoType = lottoType;
    }

    public static Lotto of(String lotto) {
        return Lotto.of(LottoNumbers.of(lotto), LottoType.MANUAL);
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers, LottoType.MANUAL);
    }

    public static Lotto of(LottoNumbers lottoNumbers, LottoType lottoType) {
        return new Lotto(lottoNumbers, lottoType);
    }

    public static Lotto of() {
        return of(new NormalShuffleStrategy());
    }

    public static Lotto of(ShuffleStrategy shuffleStrategy) {
        List<Integer> baseNumbers = makeBaseNumbers();
        shuffleStrategy.shuffle(baseNumbers);
        return of(LottoNumbers.of(pickupNumbers(baseNumbers)), LottoType.AUTO);
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

    public boolean isManual() {
        return lottoType == LottoType.MANUAL;
    }
}
