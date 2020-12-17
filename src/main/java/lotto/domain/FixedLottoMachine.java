package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoMachine {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자만 가능합니다. (입력 예시 : 1, 2, 3, 4, 5, 6)";
    private static final String NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 번호는 %d개만 가능합니다.";

    public LottoTickets generate(List<String> manualPurchaseLottoNumbers) {
        return new LottoTickets(manualPurchaseLottoNumbers.stream()
                .map(this::stringToLottoTicket)
                .collect(Collectors.toList()));
    }

    private LottoTicket stringToLottoTicket(String s) {
        LottoTicket generate = generate(s);
        if(generate.numberCount() != LottoMagicNumber.NUMBER_COUNT.get()) {
            throw new IllegalArgumentException(String.format(NUMBER_COUNT_EXCEPTION_MESSAGE, LottoMagicNumber.NUMBER_COUNT.get()));
        }
        return generate;
    }

    private LottoTicket generate(String manualPurchaseLottoNumber) {
        return new LottoTicket(Arrays.stream(manualPurchaseLottoNumber.split(", "))
                .map(this::stringToLottoNumber)
                .collect(Collectors.toList()));
    }

    private LottoNumber stringToLottoNumber(String string) {
        int number = 0;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
        return new LottoNumber(number);
    }
}
