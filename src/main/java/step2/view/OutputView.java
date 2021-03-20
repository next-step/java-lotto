package step2.view;

import step2.dto.LottoDto;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COUNT_OF_LOTTO_PURCHASED = "개를 구매 했습니다.";
    private static final String DELIMITER = ",";
    private static final String LOTTO_INFO = "[%s]\n";

    private static final String STATISTICS = "당청통계";
    private static final String DIVISION_LINE = "---------";
    private static final String COUNT_OF_MATCH = "%d개 일치%s (%d)- %d원\n";
    private static final String RETURN_OF_RATE = "총 수익률은 %5.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";
    private static final String MATCH_OF_BONUS = ", 보너스 볼 일치";

    private static final int BREAK_EVEN_POINT = 1;
    private static final int SECOND_WIN_MONEY = 30000000;


    public void lottoInfoPirnt(LottosDto lottosDto) {
        List<LottoDto> lottoDtoList = lottosDto.getLottoDtoList();
        System.out.println(lottoDtoList.size() + COUNT_OF_LOTTO_PURCHASED);
        lottoDtoList.forEach(dto -> System.out.printf(LOTTO_INFO, toString(dto.getLottoNumbers())));
    }

    private String toString(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }


    public void finish(LottoStatisticsDto lottoStatisticsDto) {
        List<Integer> rankList = lottoStatisticsDto.getRankList();
        List<Integer> winningMoney = lottoStatisticsDto.getWinningMoney();
        List<Long> countOfRank = lottoStatisticsDto.getCountOfRank();
        double ratioOfReturn = lottoStatisticsDto.getRatioOfReturn();
        statisticsPrint(rankList, winningMoney, countOfRank, ratioOfReturn);

    }

    public void statisticsPrint(List<Integer> rankList, List<Integer> winningMoney, List<Long> countOfRank, double ratioOfReturn) {
        System.out.println(STATISTICS);
        System.out.println(DIVISION_LINE);
        for (int i = 0; i < winningMoney.size(); i++) {
            System.out.printf(COUNT_OF_MATCH, rankList.get(i), printBonus(winningMoney.get(i)), winningMoney.get(i), countOfRank.get(i));
        }
        System.out.printf(RETURN_OF_RATE, ratioOfReturn, setBenefitOrLoss(ratioOfReturn));
        //총 수익률은 %5.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)
    }

    private String printBonus(int winningMoney) {
        if (winningMoney == SECOND_WIN_MONEY) {
            return MATCH_OF_BONUS;
        }
        return " ";
    }

    private String setBenefitOrLoss(double ratioOfReturn) {
        String message = LOSS;
        if (BREAK_EVEN_POINT < ratioOfReturn) {
            message = PROFIT;
        }
        return message;
    }
}
