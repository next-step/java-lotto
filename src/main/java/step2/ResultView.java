package step2;

public class ResultView {

    public ResultView() {
    }

    public static void printResult(String returnRate){
        System.out.println("당첨 통계");
        System.out.println("---------------");
        System.out.println("3개 일치 (5000원)- 개");
        System.out.println("4개 일치 (50000원)- 개");
        System.out.println("5개 일치 (150000원)- 개");
        System.out.println("6개 일치 (2000000000원)- 개");
        System.out.println("총 수익률은 "+returnRate+"입니다.");
    }
}
