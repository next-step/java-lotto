package lotto.domains;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exceptions.LottoNumberFormatException;

public enum LottoGenerator {
    INSTANCE;

    protected static final int PRICE = 1000;
    protected static final String DELIMITER_NUMBER_STRING = ",";
    
    public List<Lotto> purchaseByAuto(LottoPurchasedAmount amount) {
        return IntStream.range(0, amount.getAmount() / PRICE)
                .boxed()
                .map(i -> createLotto())
                .collect(Collectors.toList());
    }

    public Lotto purchaseByManual(String lottoString) {
        return createLotto(lottoString);
    }

    public LottoWinner createLottoWinner(String numberString, String bonusString) {
        Lotto winnerLotto = createLotto(numberString);
        LottoNumber bonusNumber = LottoNumber.of(bonusString);

        return new LottoWinner(winnerLotto, bonusNumber);
    }
    
    protected Lotto createLotto() {
        List<Integer> numbers = IntStream.rangeClosed(LottoNumber.START_NUMBER, LottoNumber.END_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return new Lotto(numbers
                .stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }

    protected Lotto createLotto(String string) {
        try {
            return new Lotto(Arrays.stream(string.split(DELIMITER_NUMBER_STRING))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .sorted()
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException(string);
        }
    }
}
