package step2.view;

public class OutputView {
    public static void printPriceNotification(){
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void printPurchaseResult(int price){
        int lottoCount = price / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
