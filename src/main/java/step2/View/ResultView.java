package step2.View;

import step2.constants.Price;
import step2.dto.JudgeResponseDTO;

public class ResultView {

    public void printResult(JudgeResponseDTO judgeResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(generateResultString(3, Price.THREE_MATCH_PRICE, judgeResponse.getThreeMatch()));
        System.out.println(generateResultString(4, Price.FOUR_MATCH_PRICE, judgeResponse.getFourMatch()));
        System.out.println(generateResultString(5, Price.FIVE_MATCH_PRICE, judgeResponse.getFiveMatch()));
        System.out.println(generateResultString(6, Price.SIX_MATCH_PRICE, judgeResponse.getSixMatch()));
        System.out.println("총 수익률은 " + judgeResponse.getProfitIndex() + "입니다.");
    }

    private String generateResultString(int count, int price, int match) {
        return count + "개 일치 (" + price + ")- " + match + "개";
    }
}
