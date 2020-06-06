package lotto.domain.prize;

import lotto.domain.lotto.LottoNumbers;

import java.util.*;

public class WinningNumbers {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String SEPARATOR = ",";
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int MIN_NUMBER_RANGE = 1;

    private List<Integer> winningNumbers;

    public WinningNumbers(String enteredWinNumber) {
        List<Integer> winningNumbers = convertWinningNumber(enteredWinNumber);
        checkSize(winningNumbers);
        checkDuplicate(winningNumbers);
        checkInRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private List<Integer> convertWinningNumber(String enteredWinNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] enteredWinNumbers = enteredWinNumber.split(SEPARATOR);
        for (String number : enteredWinNumbers) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }
        return winningNumbers;
    }

    private void checkSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는" + LOTTO_NUMBER_SIZE + "개 입니다");
        }
    }

    private void checkDuplicate(List<Integer> winningNumbers) {
        Set<Integer> winNumberSet = new HashSet<>(winningNumbers);
        if (winNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 당첨 번호가 있습니다");
        }
    }


    private void checkInRange(List<Integer> winningNumbers) {
        int max = Collections.max(winningNumbers);
        int min = Collections.min(winningNumbers);

        if (min < MIN_NUMBER_RANGE || max > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45 사이의 수 입니다");
        }
    }

    public int getMatchCount(LottoNumbers lottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers.getLottoNumbers()) {
            matchCount += checkMatch(number);
        }
        return matchCount;
    }

    private int checkMatch(int number) {
        if (this.winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

}
