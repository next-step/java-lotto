package dev.dahye.lotto.domain;

public class LottoOrder {
    private final LottoMoney lottoMoney;
    private final int countOfManualLotto;

    private LottoOrder(LottoMoney lottoMoney, int countOfManualLotto) {
        isNotNullLottoMoney(lottoMoney);
        validateManualLotto(lottoMoney, countOfManualLotto);
        this.lottoMoney = lottoMoney;
        this.countOfManualLotto = countOfManualLotto;
    }

    private void isNotNullLottoMoney(LottoMoney lottoMoney) {
        if (lottoMoney == null) {
            throw new IllegalArgumentException("로또 금액이 입력되지 않았습니다.");
        }
    }

    public static LottoOrder of(LottoMoney lottoMoney, int countOfManualLotto) {
        return new LottoOrder(lottoMoney, countOfManualLotto);
    }

    public int getCountOfAutoLotto() {
        return this.lottoMoney.calculateCountOfLotto();
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
