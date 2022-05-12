package lotto.contoller;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ResultView {
    public void printLottos(Customer customer) {
      customer.findLottos().forEach(System.out::println);
    }

    public void printWinningList(List<Rank> winningList) {
        StringBuilder builder = new StringBuilder();
        builder.append(" 당첨 통계 ");
        builder.append("\n --------- ");
        builder.append("\n 3개 일치 (5,000원)- " + winningList.stream().filter(rank -> rank == Rank.FIVE).count());
        builder.append("\n 4개 일치 (50,000원)- " + winningList.stream().filter(rank -> rank == Rank.FOUR).count());
        builder.append("\n 5개 일치 (1,500,000원)- " + winningList.stream().filter(rank -> rank == Rank.THREE).count());
        builder.append("\n 5개 일치, 보너스 볼 일치(30,000,000원)- " + winningList.stream().filter(rank -> rank == Rank.TWO).count());
        builder.append("\n 6개 일치 (2,000,000,000원)- " + winningList.stream().filter(rank -> rank == Rank.ONE).count());

        System.out.println(builder);
    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
