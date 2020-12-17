package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private static final String DELIMITER = ", ";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String PRICE_ERROR_MESSAGE = "1000원 이상의 금액을 입력해야합니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LottoMagicNumber.START.get(), LottoMagicNumber.END.get())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket generate() {
        lottoNumbersShuffle();
        List<LottoNumber> lottoNumbers = LottoMachine.lottoNumbers.subList(LottoMagicNumber.BASE_INDEX.get(), LottoMagicNumber.NUMBER_COUNT.get());
        lottoNumbers.sort(LottoNumber::ascendingSort);
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    public LottoTickets generate(int price) {
        List<LottoTicket> lottoTickets = Stream.generate(this::generate)
                .limit(purchaseQuantity(price))
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public WinningNumber winningNumber(String winningNumberString) {
        return new WinningNumber(Arrays.stream(winningNumberString.split(DELIMITER))
                .map(value -> new LottoNumber(Integer.parseInt(value)))
                .collect(Collectors.toList()));
    }

    protected int purchaseQuantity(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return price / ONE_LOTTO_PRICE;
    }

    public LottoNumber CreateBonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if (winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        };
        return lottoNumber;
    }
}
