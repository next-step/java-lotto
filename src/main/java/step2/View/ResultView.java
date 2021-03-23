package step2.View;

import step2.constants.Price;
import step2.dto.JudgeResponseDTO;

public class ResultView {

    public void printResult(JudgeResponseDTO judgeResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 " + stringifyPriceAndCount(Price.FIFTH, judgeResponse.getFifthPriceCount()));
        System.out.println("4개 일치 " + stringifyPriceAndCount(Price.FORTH, judgeResponse.getForthPriceCount()));
        System.out.println("5개 일치 " + stringifyPriceAndCount(Price.THIRD, judgeResponse.getThirdPriceCount()));
        System.out.println("5개 일치, 보너스 볼 일치" + stringifyPriceAndCount(Price.SECOND, judgeResponse.getSecondPriceCount()));
        System.out.println("6개 일치 " + stringifyPriceAndCount(Price.FIRST, judgeResponse.getFirstPriceCount()));
        System.out.println("총 수익률은 " + judgeResponse.getProfitIndex() + "입니다");
    }

    private String stringifyPriceAndCount(Price price, int count) {
        return String.format("(", price.getPrice(), "원)- ", count, "개");
    }
}
