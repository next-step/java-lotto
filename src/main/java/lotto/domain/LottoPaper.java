package lotto.domain;

import java.util.*;

public class LottoPaper {

    public static final int MATCH_COUNT = 1;
    public static final int NON_MATCH_COUNT = 0;
    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private Set<Integer> lottoNumber;

    public LottoPaper(String winningNumber) {
        lottoNumber = new HashSet<>();
        setWinningNumber(winningNumber);
    }

    public LottoPaper(RandomNumber lottoNumberStragey) {
        lottoNumber = lottoNumberStragey.getLottoNumber();
    }

    public Set<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public int checkMatchNumberCount(Set<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : winningNumbers) {
            matchCount += containCheck(number);
        }
        return matchCount;
    }

    private int containCheck(int winningNumber) {
        return lottoNumber.contains(winningNumber) ? MATCH_COUNT : NON_MATCH_COUNT;
    }

    private void setWinningNumber(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");

        if (numbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 총 6개여야 합니다.");
        }

        for (String number : numbers) {
            lottoNumber.add(checkWinningNumber(number));
        }

        if (lottoNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    public int checkWinningNumber(String numberStr) {
        int winningNumber = Integer.parseInt(numberStr);

        if (winningNumber < MIN_NUMBER_BOUND || winningNumber > MAX_NUMBER_BOUND) {
            throw new IllegalArgumentException("숫자는 1이상 45이하여야 합니다.");
        }

        return winningNumber;
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

}
