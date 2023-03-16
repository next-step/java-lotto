package lotto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LottoView {
    protected static String step1 = "구매금액을 입력해주세요";
    protected static String step2 = "지난 주 당첨 번호를 입력해 주세요.";
    protected static String step3 = "보너스 볼을 입력해 주세요.";

    public Object getClientInput(String step) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(step);
        if (step.equals(step2)) {
            return scanner.nextLine();
        }
        return scanner.nextInt();
    }

    public void printLottoList(List<Lotto> lottoList) {
        lottoList.stream().forEach(lotto -> System.out.println(lotto.getLotto().toString()));
    }

    public void printResult(Map<String, Double> resultMap) {

        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + resultMap.get("5").intValue() + "개");
        System.out.println("4개 일치 (50000원)- " + resultMap.get("4").intValue() + "개");
        System.out.println("5개 일치 (1500000원)- " + resultMap.get("3").intValue() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + resultMap.get("2").intValue() + "개");
        System.out.println("6개 일치 (2000000000원)- " + resultMap.get("1").intValue() + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", resultMap.get("PERCENTAGE")) + "% 입니다.");

    }
}
