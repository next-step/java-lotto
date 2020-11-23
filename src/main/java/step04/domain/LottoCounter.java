package step04.domain;

import exception.LackOfMoneyException;
import exception.OutOfLottoManualCountException;

import java.util.Objects;

public class LottoCounter {
    public static final int PRICE_OF_LOTTO = 1000;

    private final Integer countOfLottos;
    private final Integer countOfAutoLotto;
    private final Integer countOfManualLotto;


    private LottoCounter(Integer countOfLottos, Integer countOfManualLotto) {
        this.countOfLottos = countOfLottos;
        this.countOfManualLotto = countOfManualLotto;
        this.countOfAutoLotto = countOfLottos - countOfManualLotto;
    }

    public static LottoCounter of(Integer payment, Integer countOfManualLotto) {
        validatePayment(payment);
        Integer countOfLottos = calculateCountOfLottos(payment);
        validateCountOfManualLotto(countOfLottos, countOfManualLotto);
        return new LottoCounter(countOfLottos, countOfManualLotto);
    }

    private static void validateCountOfManualLotto(Integer countOfLottos, Integer countOfManualLotto) {
        if (countOfLottos < countOfManualLotto || countOfManualLotto < 0) {
            throw new OutOfLottoManualCountException();
        }
    }

    private static int calculateCountOfLottos(int payment) {
        return payment / PRICE_OF_LOTTO;
    }

    private static void validatePayment(Integer payment) {
        if (payment < PRICE_OF_LOTTO) {
            throw new LackOfMoneyException();
        }
    }

    public Integer getCountOfAutoLotto() {
        return countOfAutoLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCounter that = (LottoCounter) o;
        return Objects.equals(countOfLottos, that.countOfLottos) &&
                Objects.equals(countOfAutoLotto, that.countOfAutoLotto) &&
                Objects.equals(countOfManualLotto, that.countOfManualLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfLottos, countOfAutoLotto, countOfManualLotto);
    }
}
