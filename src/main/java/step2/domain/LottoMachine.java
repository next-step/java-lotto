package step2.domain;

public class LottoMachine {
    private final static int LOTTO_PRICE = 1_000;

    public static int getCount(String money) {
        int moneyToInt = invalidAndToInt(money);
        if (moneyToInt % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
        return moneyToInt / LOTTO_PRICE;
    }

    private static int invalidAndToInt(String money) {
        try {
            if (money == null || money.trim().isEmpty()) {
                throw new IllegalArgumentException("금액을 입력해주세요.");
            }
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
