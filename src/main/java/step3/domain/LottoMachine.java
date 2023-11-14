package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int NUMBER_BOX_START_NUMBER = 1;
    private static final int NUMBER_BOX_END_NUMBER = 45;
    private static final int PRICE_PER_LOTTO = 1_000;
    private static final int LOTTO_SIZE = Lotto.LOTTO_SIZE;

    private final List<Integer> numberBox;

    public LottoMachine() {
        this.numberBox = rangeClosedNumberBox();
    }

    private void validatePaidMoney(int paidMoney) {
        if (paidMoney % PRICE_PER_LOTTO != 0 || paidMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("로또 구입 금액은 " + PRICE_PER_LOTTO + "원 단위로 가능합니다. (현재 금액: " + paidMoney + "원)");
        }
    }

    private static List<Integer> rangeClosedNumberBox() {
        return IntStream.rangeClosed(NUMBER_BOX_START_NUMBER, NUMBER_BOX_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public WinningInfo play(int paidMoney, List<Integer> winningNumbers){
        validatePaidMoney(paidMoney);
        return new WinningInfo();
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumbers());
    }

    private List<LottoNumber> lottoNumbers() {
        Collections.shuffle(numberBox);
        return numberBox.subList(0, LOTTO_SIZE)
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
