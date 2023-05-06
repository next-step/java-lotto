package View.Result;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

public class ResultView {

    public void resultBuyInputCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void getLotto(ArrayList<Integer> Input) {
        System.out.println(Input);
    }

    public void getEndingMessage() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printWinnerMessage(Integer equalCount, Integer prize, Integer count) {
        System.out.println(equalCount + "개 일치 (" + prize + "원)- " + Optional.ofNullable(count).orElse(0) + "개");
    }

    public void printTotalGross(double gross) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(gross) + "입니다.");
    }

}
