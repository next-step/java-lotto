package Lotto.domain;

import Lotto.exception.SameNumberException;
import Lotto.exception.WrongNumberFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final String COMMA = ", ";
    private static final int WINNING_NUMBER_SIZE = 6;

    private List<Number> myNumbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        for (int n : numbers) {
            this.myNumbers.add(new Number(n));
        }
    }

    public Lotto(String winningNumbers) {
        String[] winningNumberArr = winningNumbers.split(COMMA);

        validate(winningNumberArr);

        for (String number : winningNumberArr) {
            myNumbers.add(new Number(Integer.parseInt(number)));
        }
    }

    private void validate(String[] winningNumberArr) {
        validateSameLottoNumber(winningNumberArr);

        validateWrongFormat(winningNumberArr);
    }

    private void validateWrongFormat(String[] winningNumberArr) {
        if (winningNumberArr.length != WINNING_NUMBER_SIZE) {
            throw new WrongNumberFormatException("입력한 당첨번호의 형식을 확인하세요.");
        }
    }

    private void validateSameLottoNumber(String[] winningNumberArr) {
        ArrayList<String> tmpList = new ArrayList<>(Arrays.asList(winningNumberArr));
        if (tmpList.size() != tmpList.stream().distinct().count()) {
            throw new SameNumberException("중복된 로또 번호가 있습니다.");
        }
    }

    public int findWinningLottoCnt(Lotto winningNumbers) {
        int cnt = 0;

        for (Number number : myNumbers) {
            cnt = findWinningLottoCnt(cnt, number.getNumber(), winningNumbers);
        }

        return cnt;
    }

    private int findWinningLottoCnt(int cnt, int answerNum, Lotto winningNumbers) {
        if (winningNumbers.getList().contains(answerNum)) {
            cnt += 1;
        }

        return cnt;
    }

    private List<Number> getList() {
        return this.myNumbers;
    }

    public int getLottoNumber(int idx) {
        return myNumbers.get(idx).getNumber();
    }

}
