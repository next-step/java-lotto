package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.dto.LottoGameResultDto;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getValue().toString());
        }
        System.out.println();
    }

    public static void printLottoGameResult(List<LottoGameResultDto> lottoGameResults) {

        for (LottoGameResultDto lottoGameResult : lottoGameResults) {
            System.out.println(lottoGameResult.getRank().getDescription() + lottoGameResult.getMatchingCount());
        }
    }

    public static void printWinningStatistics(double rate) {

        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
