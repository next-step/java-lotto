package step4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호의 범위는 " + LOTTO_NUMBER_MIN + " ~ " + LOTTO_NUMBER_MAX + "사이로 입력하셔야 합니다.");
        }
        this.number = number;
    }

    public LottoNumber(int number, boolean pass) {
        this.number = number;
    }

    public static List<LottoNumber> splitLottoNumbers(String[] inputWinningNumbers) {
        checkWinningNumberLength(inputWinningNumbers);
        checkOverlapWinningNumber(inputWinningNumbers);
        return Arrays.stream(inputWinningNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static void checkWinningNumberLength(String[] inputNewLottoNumbers) {
        if (inputNewLottoNumbers.length != LottoGenerator.WINNING_NUMBERS_LENGTH)
            throw new IllegalArgumentException("당첨번호는" + LottoGenerator.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
    }

    public static void checkOverlapWinningNumber(String[] inputNewLottoNumbers) {
        Set<String> uniqueWinningNumber = new HashSet<>(Arrays.asList(inputNewLottoNumbers));
        if (uniqueWinningNumber.size() != inputNewLottoNumbers.length)
            throw new IllegalArgumentException("당첨번호에 중복된 값이 있습니다.");
    }

    public static void checkOverlapBonusNumber(int winningNumber) {
        if (winningNumber == LottoLottery.lottoBonusNumber)
            throw new IllegalArgumentException("입력 된 당첨번호 중에 보너스 번호와 중복되는 값이 있습니다.");
    }

    public static void checkBonusNumber(Lotto inputWinningNumber) {
        new LottoNumber(LottoLottery.lottoBonusNumber);
        for (LottoNumber number : Lotto.valueOf(inputWinningNumber)) {
            checkOverlapBonusNumber(valueOf(number));
        }
    }

    public static int valueOf(LottoNumber lotto) {
        return lotto.number;
    }

    @Override
    public int compareTo(LottoNumber number){
        return Integer.compare(this.number, valueOf(number));
    }

    @Override
    public boolean equals(Object o) {
        LottoNumber compareNumber = (LottoNumber) o;
        if (this.number == compareNumber.number) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = compareNumber;
        return number == that.number;
    }
}
