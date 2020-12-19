package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoMachine implements LottoMachine {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자만 가능합니다. (입력 예시 : 1, 2, 3, 4, 5, 6)";
    private static final String NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 번호는 %d개만 가능합니다.";
    private static final int NUMBER_COUNT = 6;
    List<String> manualPurchaseLottoNumbers;
    String manualPurchaseLottoNumber;

    public FixedLottoMachine(List<String> manualPurchaseLottoNumbers) {
        this.manualPurchaseLottoNumbers = manualPurchaseLottoNumbers;
    }

    @Override
    public LottoTicket generate() {
        return new LottoTicket(Arrays.stream(manualPurchaseLottoNumber.split(", "))
                .map(this::stringToLottoNumber)
                .collect(Collectors.toList()));
    }

    @Override
    public LottoTickets generates() {
        return new LottoTickets(manualPurchaseLottoNumbers.stream()
                .map(this::stringToLottoTicket)
                .collect(Collectors.toList()));
    }

    public WinningNumber generateWinningLotto(String inputNumber) {
        return new WinningNumber(stringToLottoTicket(inputNumber).getLottoTicket());
    }

    private LottoTicket stringToLottoTicket(String manualPurchaseLottoNumber) {
        this.manualPurchaseLottoNumber = manualPurchaseLottoNumber;
        LottoTicket generate = generate();
        if(generate.numberCount() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(NUMBER_COUNT_EXCEPTION_MESSAGE, NUMBER_COUNT));
        }
        return generate;
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
