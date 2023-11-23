package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ConsoleResultView implements ResultView {
    @Override
    public void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.lotto());
        }
        System.out.println();
    }

    @Override
    public void winningStats(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계")
                .append("\n")
                .append("--------")
                .append("\n")
                .append("3개 일치(5000원)- ")
                .append(lottos.countFifthWinner()).append("\n")
                .append("4개 일치(50000원)- ")
                .append(lottos.countFourthWinner()).append("\n")
                .append("5개 일치(1500000원)- ")
                .append(lottos.countThirdWinner()).append("\n")
                .append("6개 일치(2000000000원)- ")
                .append(lottos.countFirstWinner());
//                .append("총 수익률은 ")
//                .append()
//                .append("입니다.");
        System.out.println(stringBuilder);

    }
}
