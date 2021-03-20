package lotto.view;

import lotto.domain.Rank;
import lotto.dto.LottoNumber;
import lotto.domain.Winning;
import lotto.dto.IssueNumber;
import lotto.dto.LottoNumbers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printLottoNumbers(Map<IssueNumber, LottoNumbers> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (IssueNumber issueNumber : lottoNumbers.keySet()) {
            printEachLottoNumber(lottoNumbers.get(issueNumber).getLottoNumbers());
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

        for (Rank rank : winning.getWinning().keySet()) {
            System.out.println(numberAndBonusBallString(rank) + " (" + rank.getPrice() + "원)-" + countMatchNumber(winning, rank) + "개");
        }

        int totalAmount = winning.getSumAmount();
        System.out.printf("총 수익률은 " + "%.2f" + "입니다.", totalAmount / (double) inputBuyAmount);
    }

    public String numberAndBonusBallString(Rank rank) {
        String numberAndBonusString = rank.getCount() + "개 일치";

        if (rank == Rank.SECOND) {
            numberAndBonusString += ", 보너스볼 일치";
        }

        return numberAndBonusString;
    }

    public int countMatchNumber(Winning winning, Rank rank) {
        return winning.getWinning()
                .get(rank)
                .getCount();
    }
}
