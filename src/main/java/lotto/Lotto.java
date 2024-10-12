package lotto;

import java.util.*;

public class Lotto {
    private static final Random random = new Random();
    private static final List<Integer> MATCHING_COUNT_FOR_WINNING = Arrays.asList(3, 4, 5, 6);

    private List<Integer> lottoNumbers;
    private int matchCount;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers = generateAutoLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public String toStringLottoNumbers() {
        return lottoNumbers.toString();
    }

    public List<Integer> generateAutoLottoNumbers() {
        while (lottoNumbers.size() < 6) {
            generateLottoNumber();
        }

        Collections.shuffle(this.lottoNumbers);
        return this.lottoNumbers;
    }

    private void generateLottoNumber() {
        int randomNumber = random.nextInt(45) + 1;
        if (!lottoNumbers.contains(randomNumber)) {
            lottoNumbers.add(randomNumber);
        }
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        for (int i = 0; i < 6; i++) {
            matchCount += checkMatchNumber(winningNumbers, lottoNumbers.get(i));
        }
        return matchCount;
    }

    private int checkMatchNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public int getAmountForWinningLotto() {
        if (!this.isWinningLotto()) {
            return 0;
        }
        return determineAmountByMatchCount(this.matchCount);
    }

    public boolean isWinningLotto() {
        return MATCHING_COUNT_FOR_WINNING.contains(this.matchCount);
    }

    public static int determineAmountByMatchCount(int matchCount) {
        if (matchCount == 3) {
            return 5000;
        } else if (matchCount == 4) {
            return 50000;
        } else if (matchCount == 5) {
            return 1500000;
        } else if (matchCount == 6) {
            return 2000000000;
        }
        return 0;
    }

}
