package step2.domain;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber getInstance(int number) {
        if (isNotMatchLottoNumber(number)) {
            throw new IllegalArgumentException("1부터 45사이의 보너스 번호를 입력해 주세요.");
        }
        return new BonusNumber(number);
    }

    private static boolean isNotMatchLottoNumber(int number) {
        return number < LottoConstant.START_NO || number > LottoConstant.END_NO;
    }

    public int getNumber() {
        return this.number;
    }
}
