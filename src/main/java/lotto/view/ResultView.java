package lotto.view;

public class ResultView {

    public static void printLottoResult(LottoResult result) {
        System.out.println(result.quantity() + "개를 구매했습니다.");
        result.lottos().forEach(System.out::println);
        System.out.println();
    }
}
