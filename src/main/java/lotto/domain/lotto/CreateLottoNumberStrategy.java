package lotto.domain.lotto;

@FunctionalInterface
public interface CreateLottoNumberStrategy {
    LottoNumber create();
}
