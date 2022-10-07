package lotto.ui;

public class Printer {

    public static String requestPayment() {
        System.out.println("구매금액을 입력해 주세요.");
        return InputScanner.stringScan();
    }

    public static void printLottoNumbers(int result) {
        System.out.println(String.format("%d개를 구매했습니다.", result));
    }

}
