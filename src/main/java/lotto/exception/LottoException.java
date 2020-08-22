package lotto.exception;

import lotto.utils.StringUtils;

import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.LOTTO_END_NUMBER;
import static lotto.domain.LottoNumbers.LOTTO_START_NUMBER;
import static lotto.domain.WinningNumber.INVALID_WINNING_NUMBER_SIZE;

public class LottoException {

    public static final String INVALID_LOTTO_NUMBER = "유효하지 않은 번호입니다.";
    public static final String PRINT_INVALID_LOTTO_PRICE = "로또 복권은 1000원 단위로 구매할 수 있습니다.";
    public static final String INVALID_DUPLICATION_NUMBER = "중복된 번호는 입력할 수 없습니다.";


    public static void lottoNumberRangeCheck(int number) {
        if (number < LOTTO_END_NUMBER || number < LOTTO_START_NUMBER) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER);
        }
    }

    public static void invalidLottoTicketInputPrice(int price, int lottoTicketPrice) {
        if ((price % lottoTicketPrice) != 0) {
            throw new IllegalArgumentException(PRINT_INVALID_LOTTO_PRICE);
        }
    }

    public static void inputWinningNumberDuplicationException(String[] winningNumberArray) {
        IntStream.range(0, winningNumberArray.length)
            .filter(i -> IntStream.range(0, i)
            .anyMatch(j -> winningNumberArray[i].equals(winningNumberArray[j])))
            .forEach(i -> {
                throw new IllegalArgumentException(INVALID_DUPLICATION_NUMBER);
            });
    }

    public static void winningNumberRangeException(String[] winningNumbers) {
        for (String number : winningNumbers) {
            int winnungNumber = new StringUtils(number).toInt();
            winningNumberRangeCheck(winnungNumber);
        }
    }

    private static void winningNumberRangeCheck(int number) {
        if (number > LOTTO_END_NUMBER || number < LOTTO_START_NUMBER) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER);
        }
    }

    public static void invalidWinningNumberSizeException(String[] winningNumberArray) {
        if (winningNumberArray.length != 6) {
            throw new RuntimeException(INVALID_WINNING_NUMBER_SIZE);
        }
    }

}
