package lotto.application;

import java.util.ArrayDeque;
import lotto.domain.Bank;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;

    public void lottoCount(int purchase) {
        System.out.println(purchase / LOTTO_PRICE + "개를 구매했습니다.");
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
            .forEach((rank, integer) -> stringBuilder.append(getRank(rank, integer)));
        System.out.println(stringBuilder);
    }

    private String getRank(Rank rank, Integer integer) {
        if (rank == Rank.LOSER) {
            return String.format("낙첨 %d개%n", integer);
        }
        return String.format("%d개 일치 (%d원)- %d개%n", rank.getMatchCount(), rank.getReward(), integer);
    }

    @SuppressWarnings("all")
    private void printLottoNumbers(StringBuilder stringBuilder, ArrayDeque<LottoNumber> lottosList) {
        while (lottosList.size() != 1) {
            LottoNumber lottoNumber = lottosList.poll();
            stringBuilder.append(lottoNumber.lottoNumber()).append(", ");
        }
        LottoNumber lottoNumber = lottosList.poll();
        stringBuilder.append(lottoNumber.lottoNumber()).append("]").append("\n");
    }

    public void winningStatistics(Bank bank, int purchacse) {
        System.out.println("총 수익률은 " + bank.yield(purchacse) + "입니다.");
    }

}
