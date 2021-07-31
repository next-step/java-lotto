package step2;

public class LottoOutputView {
    public static void printLottoQuantity(LottoBucket lottoBucket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoBucket.size());
    }

    public static void printLottoAll(LottoBucket lottoBucket) {
        System.out.println(lottoBucket.toString());
    }

    public static void printLottoWinStatistics() {
        ;
    }
}
