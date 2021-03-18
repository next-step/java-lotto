package lotto.view;

import lotto.domain.Amount;
import lotto.domain.MatchNumber;
import lotto.dto.LottoNumber;
import lotto.domain.Winning;
import lotto.dto.IssueNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printLottoNumbers(Map<IssueNumber, List<LottoNumber>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (IssueNumber issueNumber : lottoNumbers.keySet()) {
            printEachLottoNumber(lottoNumbers.get(issueNumber));
        }

        System.out.println();
    }

    public void printEachLottoNumber(List<LottoNumber> lottoNumber) {
        System.out.println(lottoNumber.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList()));
    }

    public void printStatistics(Winning winning, int inputBuyAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (MatchNumber matchNumber : winning.getWinning().keySet()) {
            System.out.println(matchNumber.getMatchNumber() + "개 일치 (" +
                    Amount.getWinningMoney(matchNumber.getMatchNumber()) + "원)-" +
                    winning.getWinning()
                            .get(matchNumber)
                            .getCount() + "개");
        }

        int totalAmount = winning.getSumAmount();
        System.out.printf("총 수익률은 " + "%.2f" + "입니다.", totalAmount / (double) inputBuyAmount);
    }
}
