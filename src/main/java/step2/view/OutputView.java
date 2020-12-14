package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoNumbers;
import step2.domain.LottoResult;

public class OutputView {

    public static void outputMessageLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder builder = new StringBuilder()
                .append(lottoNumbers.getLottoNumber().size())
                .append("개를 구매했습니다.");
        System.out.println(builder.toString());

        for (Lotto number : lottoNumbers.getLottoNumber()) {
            System.out.println(number);
        }
    }

    public static void outputMessageLottoResult(int amount, LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)-" + lottoResult.winningResult(3) + "개");
        System.out.println("4개 일치 (50000원)-" + lottoResult.winningResult(4) + "개");
        System.out.println("5개 일치 (1500000원)-" + lottoResult.winningResult(5) + "개");
        System.out.println("6개 일치 (2000000000원)-" + lottoResult.winningResult(6) + "개");

        outputMessageLottoYield(amount,lottoResult.winnings());
    }

    public static void outputMessageLottoYield(int amount, long sum) {
        double yield = (double)sum/(double)amount;
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.2f", yield));
        System.out.print("입니다(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println();
    }


}
