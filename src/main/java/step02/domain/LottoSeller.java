package step02.domain;

import java.util.List;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private LottoSeller() {
    }

    public static LottoList sell(int price, List<String> manualLottoNumbers) {
        validateManualLottoNumbers(manualLottoNumbers);
        int manualLottoCount = manualLottoNumbers.size();
        if (onlyManualLotto(price, manualLottoCount)) {
            return LottoMaker.makeManualLotto(manualLottoNumbers);
        }

        return LottoMaker.makeLotto(getAutoLottoCount(price, manualLottoCount), manualLottoNumbers);
    }

    private static boolean onlyManualLotto(int price, int manualLottoCount) {
        return getAutoLottoCount(price, manualLottoCount) == 0;
    }

    private static int getAutoLottoCount(int price, int manualLottoCount) {
        validatePrice(price);
        int autoLottoCount = (price / LOTTO_PRICE) - manualLottoCount;
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("자동 로또 발급 개수는 0 미만일 수 없습니다.");
        }

        return autoLottoCount;
    }

    private static void validatePrice(int price) {
        validatePriceAmount(price);
        validatePriceRange(price);
    }

    private static void validatePriceAmount(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("금액은 0원 이하의 금액을 입력할 수 없습니다. | 입력한 금액: " + price);
        }
    }

    private static void validatePriceRange(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 " + LOTTO_PRICE + " 단위의 금액을 입력해야합니다. | 입력된 금액: " + price);
        }
    }

    private static void validateManualLottoNumbers(List<String> manualLottoNumbers) {
        if (manualLottoNumbers == null || manualLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("수동 로또 넘버는 비어있을 수 없습니다.");
        }
    }
}
