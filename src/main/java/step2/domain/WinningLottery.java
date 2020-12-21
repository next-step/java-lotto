package step2.domain;

import step2.util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottery {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final int LOTTO_BALL_START_NUMBER = 1;
    private static final int LOTTO_BALL_END_NUMBER = 45;
    
    private Lottery winningLottery;

    /**
     * 당첨 복권(당첨 번호를 가진 복권 객체)을 생성하는 생성자
     * @param winningNumbers 입력 받은 당첨 번호 문자열
     */
    public WinningLottery(String winningNumbers) {
        String[] splitNumbers = splitNumbers(winningNumbers);

        if (splitNumbers.length != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_MUST_BE_6);
        }
        winningLottery = new Lottery(convertToInteger(splitNumbers));
    }

    /**
     * 사용자에게 입력받은 당첨번호 문자열을 delimiter를 이용하여 배열로 split하는 메소드
     * @param winningNumbers 사용자에게 입력받은 문자열
     * @return 분리된 문자열 배열
     */
    private String[] splitNumbers(String winningNumbers) {
        return winningNumbers.replaceAll("\\s+","").split(",");
    }

    /**
     * 입력 받은 당첨 번호를 숫자로 변환해주는 메소드
     * @param winningNumbers 당첨 번호
     * @return 당첨 번호 리스트
     */
    private List<Integer> convertToInteger(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                    .map(this::convertNumber)
                    .collect(Collectors.toList());
    }

    /**
     * 개별 당첨 번호를 숫자로 변환, 올바른 범위에 있는지 검사하는 메소드
     * @param number 개별 당첨 번호
     * @return 숫자로 변환된 당첨 번호
     */
    private int convertNumber(String number) {
        int convertedNumber = Integer.parseInt(number);

        if (convertedNumber < LOTTO_BALL_START_NUMBER || convertedNumber > LOTTO_BALL_END_NUMBER) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_INVALID_RANGE);
        }
        return convertedNumber;
    }

    public Lottery getWinningLottery() {
        return this.winningLottery;
    }
}
