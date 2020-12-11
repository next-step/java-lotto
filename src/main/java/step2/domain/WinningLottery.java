package step2.domain;

import step2.util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottery {
    
    private Lottery winningLottery;

    /**
     * 당첨 복권(당첨 번호를 가진 복권 객체)을 생성하는 생성자
     * @param winningNumbers 입력 받은 당첨 번호 문자열
     */
    public WinningLottery(String[] winningNumbers) {
        if (winningNumbers.length != Constants.WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_MUST_BE_6);
        }
        winningLottery = new Lottery(convertToInteger(winningNumbers));
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

        if (convertedNumber >= 1 && convertedNumber <= 45) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_INVALID_RANGE);
        }
        return convertedNumber;
    }
}
