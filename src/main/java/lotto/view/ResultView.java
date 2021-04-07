package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import lotto.dto.LottoOrderedDto;
import lotto.dto.LottoOrderResultDto;
import lotto.dto.LottoScoreDto;
import lotto.dto.LottoScoreResultDto;

public class ResultView {
    public static void printLottoOrderResult(LottoOrderResultDto lottoOrderResultDto) {
        int automaticLottoCount = lottoOrderResultDto.getOrderResult().size() - lottoOrderResultDto.getPreOrderedLottoCount();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                lottoOrderResultDto.getPreOrderedLottoCount(), automaticLottoCount);

        List<LottoOrderedDto> lottoNumberList = lottoOrderResultDto.getOrderResult();
        lottoNumberList.forEach(ResultView::printLottoNumber);
    }

    public static void printLottoScoringResult(LottoScoreResultDto lottoScoreResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoScoreDto> lottoScoreDtoList = lottoScoreResultDto.getLottoScoreDtoList();
        Collections.sort(lottoScoreDtoList);
        lottoScoreDtoList.stream().forEach(ResultView::printLottoScore);
    }

    public static void printLottoEarningRate(String earningRate) {
        System.out.printf("총 수익률은 " + earningRate + "입니다.");
        if (Double.parseDouble(earningRate) < 1) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n");
        }
    }

    public static void printLottoNumber(LottoOrderedDto lottoDto) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        lottoDto.getLottoNumbers().stream()
                .map(String::valueOf)
                .forEach(stringJoiner::add);

        System.out.println(stringJoiner.toString());
    }

    public static void printLottoScore(LottoScoreDto lottoScoreDto) {
        if (lottoScoreDto.getScore() == 0) {
            return;
        }
        System.out.printf("%d개 일치", lottoScoreDto.getMatchingBallCount());
        if (lottoScoreDto.getScore() == 11) {
            System.out.printf(", 보너스 볼 일치(%d원) - %d개%n", lottoScoreDto.getPrizeAmount(), lottoScoreDto.getWinners());
            return;
        }
        System.out.printf(" (%d원)- %d개%n", lottoScoreDto.getPrizeAmount(), lottoScoreDto.getWinners());
    }
}
