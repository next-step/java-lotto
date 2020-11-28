package step4.util;

public class LottoNumberQtyValidate {
    private static final int LOTTO_MANUAL_MIN_COUNT = 1;

    public static void validate(int manualLottoQty) {
        if (manualLottoQty < LOTTO_MANUAL_MIN_COUNT) {
            throw new IllegalArgumentException("로또 구입 갯수는 최소 1개부터 입니다.");
        }
    }
}
