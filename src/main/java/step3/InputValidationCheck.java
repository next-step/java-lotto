package step3;

import java.util.*;

// TODO: [완료] 데이터에 대한 유효성 체크를 한곳으로 모아서 처리하지 말고, 적절한 객체로 위임해 볼 것을 추천한다.
// TODO: [진행중] 입력하는 돈, 수익률 계산 등 돈과 관련한 모든 로직을 Money와 같은 객체를 추가해 구현해 보는 것은 어떨까?
public class InputValidationCheck {

    // TODO: Lotto와 같은 객체가 데이터가 유효한지 체크하는 것은 어떨까?
//    public static void checkWinningNumberLength(String[] trimWinningNumbers) {
//        if (trimWinningNumbers.length != LottoGenerator.WINNING_NUMBERS_LENGTH)
//            throw new IllegalArgumentException("당첨번호는" + LottoGenerator.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
//    }

//    public static int[] checkWinningNumberRange(String[] trimWinningNumbers) {
//        int[] winningNumbers = new int[LottoGenerator.WINNING_NUMBERS_LENGTH];
//        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
//            winningNumbers[i] = Integer.parseInt((trimWinningNumbers[i]));
//            checkEachWinningNumber(winningNumbers[i]);
//        }
//
//        return winningNumbers;
//    }

//    public static void checkOverlapWinningNumber(String[] winningNumbers) {
//        Set<String> uniqueWinningNumber = new HashSet<>(Arrays.asList(winningNumbers));
//        if (uniqueWinningNumber.size() != winningNumbers.length)
//            throw new IllegalArgumentException("당첨번호에 중복된 값이 있습니다.");
//    }

//    public static void checkBonusNumber(List<Integer> inputWinningNumberList) {
//        checkEachWinningNumber(Lotto.LOTTO_BONUS_NUMBER);
//        for (int winningNumber : inputWinningNumberList) {
//            checkOverlapBonusNumber(winningNumber);
//        }
//    }

//    public static void checkEachWinningNumber1(int bonusNumber) {
//        if (bonusNumber > Lotto.LOTTO_NUMBER_MAX || bonusNumber < Lotto.LOTTO_NUMBER_MIN)
//            throw new IllegalArgumentException("당첨번호와 보너스 볼은 " + Lotto.LOTTO_NUMBER_MIN + " ~ " + Lotto.LOTTO_NUMBER_MAX + "사이로 입력하셔야 합니다.");
//    }


    public static void checkOverlapBonusNumber(int winningNumber) {
        if (winningNumber == LottoNumbers.LOTTO_BONUS_NUMBER)
            throw new IllegalArgumentException("입력 된 당첨번호 중에 보너스 번호와 중복되는 값이 있습니다.");
    }
}
