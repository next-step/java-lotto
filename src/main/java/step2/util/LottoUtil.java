package step2.util;

public class LottoUtil {

    public static void purchaseAmountValidate(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("구입 금액 값이 없습니다.");
        }

        if (amount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원부터 입력가능합니다.");
        }
    }

    public static void lottoNumberSizeValidate(String lastWeekNumber) {
        if (lastWeekNumber == null || lastWeekNumber.isEmpty()) {
            throw new IllegalArgumentException("지난 로또 번호를 입력해 주세요.");
        }
        String[] lottoNumbers = lastWeekNumber.split(",");
        if(lottoNumbers.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }

    }
}
