package autolotto;

public class LottoOutput {
    public void println(String printable) {
        System.out.println(printable);
    }

    public void printResult(Results results) {
        println("당첨통계");
        println("----------------");
        results.getResults().forEach(result -> println(result.format()));
    }

    public void printProfit(Lottos lottos, Results results) {
        System.out.printf("총 수익률은 %.0f%%입니다. (100%%가 구매한 금액만큼 돈이 당첨된 것.) %n", (double) results.prize() / lottos.cost() * 100);
    }
}
