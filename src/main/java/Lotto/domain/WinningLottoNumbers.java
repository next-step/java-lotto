package Lotto.domain;

import Lotto.exception.WinningNumberWrongFormat;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    public List<Integer> winningNumbers = new ArrayList<>();

    private static final String COMMA = ", ";
    private static final int WINNING_NUMBER_SIZE = 6;

    public WinningLottoNumbers(String splitNumbers) {
        String[] winningNumberArr = splitNumbers.split(COMMA);

        validate(winningNumberArr);

        for (String number : winningNumberArr) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    private void validate(String[] winningNumberArr) {
        if (winningNumberArr.length != WINNING_NUMBER_SIZE) {
            throw new WinningNumberWrongFormat("입력한 당첨번호의 형식을 확인하세요.");
        }
    }

    public int checkWinningLottoNumbers(List<Integer> numbers) {
        int cnt = 0;

        for (int num : winningNumbers) {
            cnt = checkWinningLottoNumbers(cnt, num, numbers);
        }

        return cnt;
    }

    private int checkWinningLottoNumbers(int cnt, int answerNum, List<Integer> numbers) {
        if (numbers.contains(answerNum)) {
            cnt += 1;
        }

        return cnt;
    }
}
