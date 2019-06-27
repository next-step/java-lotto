package step2;

public class ValidationCheck {

    public static void inputPriceIsEmpty(String str) {
        if ("".equals(str) || str.isEmpty()) {
            throw new NullPointerException("구매금액을 입력하지 않았니다. 로또 프로그램을 종료합니다.");
        }
    }

    public static void inputLuckyNumberIsEmpty(String str) {
        if ("".equals(str) || str.isEmpty()) {
            throw new NullPointerException("당첨번호를 입력하지 않았니다. 로또 프로그램을 종료합니다.");
        }
    }
}
