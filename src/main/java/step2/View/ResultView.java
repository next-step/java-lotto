package step2.View;

import step2.dto.JudgeResponseDTO;

public class ResultView {

    public void printResult(JudgeResponseDTO judgeResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 " + stringifyPriceAndCount(judgeResponse.getFifthPrice(), judgeResponse.getFifthPriceCount()));
        System.out.println("4개 일치 " + stringifyPriceAndCount(judgeResponse.getForthPrice(), judgeResponse.getForthPriceCount()));
        System.out.println("5개 일치 " + stringifyPriceAndCount(judgeResponse.getThirdPrice(), judgeResponse.getThirdPriceCount()));
        System.out.println("5개 일치, 보너스 볼 일치" + stringifyPriceAndCount(judgeResponse.getSecondPrice(), judgeResponse.getSecondPriceCount()));
        System.out.println("6개 일치 " + stringifyPriceAndCount(judgeResponse.getFirstPrice(), judgeResponse.getFirstPriceCount()));
        System.out.println("총 수익률은 " + judgeResponse.getProfitIndex() + "입니다");
    }

    private String stringifyPriceAndCount(int price, int count) {
        return String.format("(%d원)-%d개", price, count);
    }
}
