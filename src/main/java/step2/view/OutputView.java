package step2.view;

import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;

import java.util.Map;

public class OutputView {

    public static void outputMessageLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder builder = new StringBuilder()
                .append(lottoNumbers.getLottoNumber().size())
                .append("개를 구매했습니다.");
        System.out.println(builder.toString());

        for (LottoNumber number : lottoNumbers.getLottoNumber()) {
            System.out.println(number);
        }
    }

    public static void outputMessageLottoResult(int amount, Map<Integer, Long> resultMap) {
        long all =  resultMap.getOrDefault(6,0l);
        long five =  resultMap.getOrDefault(5,0l);
        long four =  resultMap.getOrDefault(4,0l);
        long three =  resultMap.getOrDefault(3,0l);
        long sum = all * 2000000000l + five * 1500000l + four * 50000l + three * 5000l;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)-" + three + "개");
        System.out.println("4개 일치 (50000원)-" + four + "개");
        System.out.println("5개 일치 (1500000원)-" + five + "개");
        System.out.println("6개 일치 (2000000000원)-" + all + "개");

        outputMessageLottoYield(amount,sum);
    }

    public static void outputMessageLottoYield(int amount, long sum) {
        double yield = (double)sum/(double)amount;
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.2f", yield));
        System.out.print("입니다(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println();
    }


}
