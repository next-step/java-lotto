package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomLottoMachine {
    private static final String DELIMITER = ", ";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String PRICE_ERROR_MESSAGE = "자동 로또를 발급하기 위한 최소 금액은 1000원 입니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자만 가능합니다. (입력 예시 : 1, 2, 3, 4, 5, 6)";
    private static final String NUMBERS_COUNT_ERROR_MESSAGE = "당첨 번호는 %d개를 입력해야합니다.";
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LottoMagicNumber.START.get(), LottoMagicNumber.END.get())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket generate() {
        lottoNumbersShuffle();
        List<LottoNumber> lottoNumbers = RandomLottoMachine.lottoNumbers.subList(LottoMagicNumber.BASE_INDEX.get(), LottoMagicNumber.NUMBER_COUNT.get());
        lottoNumbers.sort(LottoNumber::ascendingSort);
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    public LottoTickets generate(int price) {
        List<LottoTicket> lottoTickets = Stream.generate(this::generate)
                .limit(purchaseQuantity(price))
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    public WinningNumber winningNumber(String winningNumberString) {
        String[] strings = winningNumberString.split(DELIMITER);
        if (strings.length != LottoMagicNumber.NUMBER_COUNT.get()) {
            throw new IllegalArgumentException(String.format(NUMBERS_COUNT_ERROR_MESSAGE, LottoMagicNumber.NUMBER_COUNT.get()));
        }
        return new WinningNumber(Arrays.stream(strings)
                .map(this::stringToLottoNumber)
                .collect(Collectors.toList()));
    }

    public LottoNumber CreateBonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if (winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        };
        return lottoNumber;
    }

    protected int purchaseQuantity(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return price / ONE_LOTTO_PRICE;
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
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
