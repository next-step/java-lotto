package lotto.utils;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.*;

public class LottoValidationUtils {

    private static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1부터 45까지 사용할 수 있습니다.";
    private static final String INVALID_LOTTO_NUMBER_TO_SIX = "로또 숫자는 6개 입니다.";
    private static final String INVALID_LOTTO_NUMBER_TO_FORTY_FIVE = "로또 번호 총 개수는 45개 입니다.";
    private static final String NUMERICAL_REGULAR_EXPRESSION = "^[0-9]+$";

    private static final String PRINT_INVALID_LOTTO_PRICE = "로또 복권은 1000원 단위로 구매할 수 있습니다.";
    private static final String INVALID_DUPLICATION_NUMBER = "중복된 번호는 입력할 수 없습니다.";
    private static final String INVALID_INPUT_PRICE = "지불 금액은 숫자만 입력할 수 있습니다.";

    private LottoValidationUtils() {
    }

    public static void validateLottoNumberRange(List<Integer> lottoTicket) {
        lottoTicket.forEach(LottoValidationUtils::validateLottoNumberRange);
    }

    private static void validateLottoNumberRange(int number) {
        if (number < NUMBER_ONE || number > NUMBER_FORTY_FIVE) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateLottoNumberSizeToSix(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_SIX) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER_TO_SIX);
        }
    }

    public static void validateLottoNumberSizeToFortyFive(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_FORTY_FIVE) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER_TO_FORTY_FIVE);
        }
    }

    public static void validateNumberDuplication(List<Integer> lottoTicket) {
        IntStream.range(NUMBER_ZERO, lottoTicket.size())
                .filter(i -> IntStream.range(NUMBER_ZERO, i)
                .anyMatch(j -> lottoTicket.get(i).equals(lottoTicket.get(j))))
                .forEach(i -> {
                    throw new IllegalArgumentException(INVALID_DUPLICATION_NUMBER);
                });
    }

    public static void validateLottoTicketPrice(int price, int lottoTicketPrice) {
        if ((price % lottoTicketPrice) != 0) {
            throw new IllegalArgumentException(PRINT_INVALID_LOTTO_PRICE);
        }
    }

    public static void validateInputNegativeNumber(int price) {
        String priceToString = String.valueOf(price);
        if (!priceToString.matches(NUMERICAL_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(INVALID_INPUT_PRICE);
        }
    }

}
