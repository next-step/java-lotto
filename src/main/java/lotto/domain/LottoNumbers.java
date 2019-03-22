package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        // 번호가 6개인가
        compareIndex(lottoNumbers.size() < 6);
        // 중복된 숫자는 없는가
        // 1~45 사이의 숫자인가
        for (Integer number : lottoNumbers) {
            int forward = lottoNumbers.indexOf(number);
            int reverseIndex = lottoNumbers.lastIndexOf(number);
            compareIndex(forward != reverseIndex);
            compareIndex(number < 1 || number > 45);
        }
    }

    private void compareIndex(boolean condition) {
        if (condition) {
            throw new IllegalArgumentException();
        }
    }

    int size() {
        return lottoNumbers.size();
    }

    boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    int matchCount(WinningLotto winningLotto) {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            matchCount = getMatchCount(winningLotto, matchCount, number);
        }

        return matchCount;
    }

    private int getMatchCount(WinningLotto winningLotto, int matchCount, Integer number) {
        if(winningLotto.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    Winning matchResult(WinningLotto winningLotto) {
        int count = matchCount(winningLotto);
        switch (count) {
            case 3:
                return Winning.FOURTH;
            case 4:
                return Winning.THIRD;
            case 5:
                return Winning.SECOND;
            case 6:
                return Winning.FIRST;
        }
        return Winning.NO_MATCH;
    }
}
