package dev.dahye.lotto.domain;

import java.util.Objects;

public class LottoOrder {
    private final LottoMoney lottoMoney;
    private final int countOfManualLotto;

    private LottoOrder(LottoMoney lottoMoney, int countOfManualLotto) {
        Objects.requireNonNull(lottoMoney, "lottoMoney must not be null");

        validateManualLotto(lottoMoney, countOfManualLotto);
        this.lottoMoney = lottoMoney;
        this.countOfManualLotto = countOfManualLotto;
    }

    public static LottoOrder of(LottoMoney lottoMoney, int countOfManualLotto) {
        return new LottoOrder(lottoMoney, countOfManualLotto);
    }

    public int getCountOfAutoLotto() {
        return this.lottoMoney.calculateCountOfLotto() - countOfManualLotto;
    }

    public int getCountOfManualLotto() {
        return countOfManualLotto;
    }

    private void validateManualLotto(LottoMoney lottoMoney, int countOfManualLotto) {
        validateGreaterThan(lottoMoney.calculateCountOfLotto(), countOfManualLotto, "수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
        validateGreaterThan(countOfManualLotto, 0, "수동 로또 갯수는 음수일 수 없습니다.");
    }

    private void validateGreaterThan(int countOfLotto, int countOfManualLotto, String s) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException(s);
        }
    }
}
