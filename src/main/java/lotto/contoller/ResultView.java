package lotto.contoller;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ResultView {

    public ResultView() {

    }

    public void printLottos(Customer customer) {
      customer.printLottoList();
    }

    public void printWinningList(List<Rank> winningList) {
        System.out.println(" 당첨 통계 ");
        System.out.println(" --------- ");
        System.out.println("3개 일치 (5000원)- " + winningList.stream().filter(rank -> rank == Rank.FOUR).collect(Collectors.toList()).size());
        System.out.println("4개 일치 (50000원)- " + winningList.stream().filter(rank -> rank == Rank.THREE).collect(Collectors.toList()).size());
        System.out.println("5개 일치 (1500000원)- " + winningList.stream().filter(rank -> rank == Rank.TWO).collect(Collectors.toList()).size());
        System.out.println("6개 일치 (2000000000원)- " + winningList.stream().filter(rank -> rank == Rank.ONE).collect(Collectors.toList()).size());

    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
