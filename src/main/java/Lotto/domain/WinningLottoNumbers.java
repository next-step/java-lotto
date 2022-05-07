package Lotto.domain;

import Lotto.exception.SameNumberException;
import Lotto.exception.WrongNumberFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLottoNumbers {
//    public List<Integer> winningNumbers = new ArrayList<>();
//
//    private static final String COMMA = ", ";
//    private static final int WINNING_NUMBER_SIZE = 6;
//
//    public WinningLottoNumbers(String splitNumbers) {
//        String[] winningNumberArr = splitNumbers.split(COMMA);
//
//        validate(winningNumberArr);
//
//        for (String number : winningNumberArr) {
//            winningNumbers.add(Integer.parseInt(number));
//        }
//    }
//
//    private void validate(String[] winningNumberArr) {
//        validateSameLottoNumber(winningNumberArr);
//
//        validateWrongFormat(winningNumberArr);
//    }
//
//    private void validateWrongFormat(String[] winningNumberArr) {
//        if (winningNumberArr.length != WINNING_NUMBER_SIZE) {
//            throw new WrongNumberFormatException("입력한 당첨번호의 형식을 확인하세요.");
//        }
//    }
//
//    private void validateSameLottoNumber(String[] winningNumberArr) {
//        ArrayList<String> tmpList = new ArrayList<>(Arrays.asList(winningNumberArr));
//        if(tmpList.size() != tmpList.stream().distinct().count()) {
//            throw new SameNumberException("중복된 로또 번호가 있습니다.");
//        }
//    }
//
//    public int findWinningLottoCnt(List<Integer> numbers) {
//        int cnt = 0;
//
//        for (int num : winningNumbers) {
//            cnt = findWinningLottoCnt(cnt, num, numbers);
//        }
//
//        return cnt;
//    }
//
//    private int findWinningLottoCnt(int cnt, int answerNum, List<Integer> numbers) {
//        if (numbers.contains(answerNum)) {
//            cnt += 1;
//        }
//
//        return cnt;
//    }
}
