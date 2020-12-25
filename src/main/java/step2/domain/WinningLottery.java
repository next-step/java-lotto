package step2.domain;

import step2.exception.NumberMustBeSixException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottery {

    private static final int LOTTO_NUMBERS_LENGTH = 6;

    public static final String WINNING_NUMBER_MUST_BE_6 = "당첨 번호는 6개여야만 합니다.";
    public static final String WINNING_NUMBER_INVALID_RANGE = "당첨 번호는 1 이상 45 이하의 범위여야합니다.";
    
    private Lottery winningLottery;

    /**
     * 당첨 복권(당첨 번호를 가진 복권 객체)을 생성하는 생성자
     * @param winningNumbers 입력 받은 당첨 번호 문자열
     */
    public WinningLottery(String winningNumbers) {
        String[] splitNumbers = splitNumbers(winningNumbers);

        if (splitNumbers.length != LOTTO_NUMBERS_LENGTH) {
            throw new NumberMustBeSixException(WINNING_NUMBER_MUST_BE_6);
        }

        winningLottery = new Lottery(makeLottoNumbers(splitNumbers));
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
     * 입력 받은 당첨 번호 배열을 LottoNumber 리스트로 변환해주는 메소드
     * @param winningNumbers 당첨 번호 배열
     * @return 당첨 번호 리스트
     */
    private List<LottoNumber> makeLottoNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .map(this::convertToLottoNumbers)
                .collect(Collectors.toList());
    }

    /**
     * 문자열 번호를 LottoNumber 객체로 반환
     * @param number 당첨 번호
     * @return LottoNumber
     */
    private LottoNumber convertToLottoNumbers(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    public List<LottoNumber> getWinningNumbers() {
        return this.winningLottery.getNumbers();
    }
}
