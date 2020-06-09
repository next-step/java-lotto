package dev.dahye.lotto.domain;

public class LottoOrder {
    private static final int ZERO_VALUE = 0;

    private final LottoMoney lottoMoney;
    private final int countOfManualLotto;

    private LottoOrder(LottoMoney lottoMoney, int countOfManualLotto) {
        this.lottoMoney = lottoMoney;
        this.countOfManualLotto = countOfManualLotto;
        validateManualLotto();
    }

    public static LottoOrder of(LottoMoney lottoMoney, int countOfManualLotto) {
        return new LottoOrder(lottoMoney, countOfManualLotto);
    }

    public int getCountOfManualLotto() {
        return countOfManualLotto;
    }

    public boolean isExistManualLotto() {
        return countOfManualLotto > ZERO_VALUE;
    }

    private void validateManualLotto() {
        validateGreaterThan(lottoMoney.calculateCountOfLotto(), countOfManualLotto, "수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
        validateGreaterThan(countOfManualLotto, 0, "수동 로또 갯수는 음수일 수 없습니다.");
    }

    private void validateGreaterThan(int countOfLotto, int countOfManualLotto, String s) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException(s);
        }
    }
}
