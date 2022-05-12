package Lotto.domain;

import Lotto.exception.SameNumberException;
import Lotto.exception.WrongNumberFormatException;
import Lotto.util.NumberFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final String DELIMITER = ", ";
    private static final int WINNING_NUMBER_SIZE = 6;

    private List<Number> myNumbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        for (int number : numbers) {
            this.myNumbers.add(Number.getNumber(number));
        }
    }

    public Lotto(String winningNumbers) {
        String[] winningNumberArr = winningNumbers.split(DELIMITER);

        validate(winningNumberArr);

        for (String number : winningNumberArr) {
            myNumbers.add(Number.getNumber(Integer.parseInt(number)));
        }
    }

    public Lotto(String winningNumberStr, Number bonusNumber) {
        this(winningNumberStr);

        isDuplicateNumber(bonusNumber);
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
        if (tmpList.size() != sizeOfDuplicatesRemoved(tmpList)) {
            throw new SameNumberException("중복된 로또 번호가 있습니다.");
        }
    }

    private long sizeOfDuplicatesRemoved(ArrayList<String> tmpList) {
        return tmpList.stream().distinct().count();
    }

    public int findWinningLottoCnt(Lotto winningNumbers) {
        int cnt = 0;

        for (Number number : myNumbers) {
            cnt = findWinningLottoCnt(cnt, number, winningNumbers);
        }

        return cnt;
    }

    private int findWinningLottoCnt(int cnt, Number number, Lotto winningNumbers) {
        if (winningNumbers.getList().contains(number)) {
            cnt += 1;
        }

        return cnt;
    }

    private void isDuplicateNumber(Number bonusNumber) {
        if(myNumbers.contains(bonusNumber)) {
            throw new SameNumberException("당첨번호와 보너스 번호가 중복됩니다.");
        }
    }

    public boolean isBonusNumber(Number bonusNumber) {
        return myNumbers.contains(bonusNumber);
    }

    private List<Number> getList() {
        return this.myNumbers;
    }

    public int getLottoNumber(int idx) {
        return myNumbers.get(idx).getNumber();
    }


}
