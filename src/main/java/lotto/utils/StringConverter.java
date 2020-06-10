package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoNumber;
import lotto.model.PurchasedLottoTicket;


public final class StringConverter {

    private static final String DELIMITER = ",";

    public static List<Integer> convertTo(String s) {
        return Arrays.stream(s.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static PurchasedLottoTicket convertToLottoNumbers(String s) {
        List<LottoNumber> numbers = Arrays.stream(s.split(DELIMITER))
            .map(v -> LottoNumber.of(Integer.parseInt(v)))
            .collect(Collectors.toList());

        return PurchasedLottoTicket.create(numbers);
    }
}
