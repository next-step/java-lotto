package lotto.application;

import java.util.ArrayDeque;
import lotto.domain.Bank;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {

    private final LottoPrice lottoPrice;

    public OutputView(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public void lottoCount(int purchaseMoney) {
        System.out.println(lottoPrice.lottoCount(purchaseMoney) + "개를 구매했습니다.");
    }

    public void lottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.lottos().forEach(lotto -> {
            stringBuilder.append("[");
            ArrayDeque<LottoNumber> lottosList = new ArrayDeque<>(lotto.lotto());
            printLottoNumbers(stringBuilder, lottosList);
        });
        System.out.println(stringBuilder);
    }

    public void winningStatistics(Bank bank) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        StringBuilder stringBuilder = new StringBuilder();
        bank.winningConfirmation()
            .forEach((rank, count) -> stringBuilder.append(getRank(rank, count)));
        System.out.println(stringBuilder);
    }

    private String getRank(Rank rank, Integer count) {
        if (rank == Rank.LOSER) {
            return String.format("낙첨 %d개%n", count);
        }
        return String.format("%d개 일치 (%d원)- %d개%n", rank.matchCount(), rank.reward(), count);
    }

    @SuppressWarnings("all")
    private void printLottoNumbers(StringBuilder stringBuilder, ArrayDeque<LottoNumber> lottosList) {
        while (lottosList.size() != 1) {
            LottoNumber lottoNumber = lottosList.poll();
            stringBuilder.append(lottoNumber.value()).append(", ");
        }
        LottoNumber lottoNumber = lottosList.poll();
        stringBuilder.append(lottoNumber.value()).append("]").append("\n");
    }

    public void winningStatistics(Bank bank, int purchase) {
        System.out.println("총 수익률은 " + bank.yield(purchase) + "입니다.");
    }

}
