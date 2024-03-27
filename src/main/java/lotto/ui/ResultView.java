package lotto.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

public class ResultView {

    private static final String DEFAULT_MESSAGE_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String SECOND_MESSAGE_FORMAT = "%s개 일치, 보너스 볼 일치(%s원) - %s개";

    public void printPurchaseCount(List<LottoTicket> lottoTickets) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoTickets.size()));
        for (LottoTicket lottoTicket : lottoTickets) {
            String displayNumbers = lottoTicket.getLottoNumbers().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .collect(Collectors.joining(", "));
            System.out.println(String.format("[%s]", displayNumbers));
        }
    }

    public void printMatchResult(Map<LottoRank, Integer> result) {
        LottoRank[] values = LottoRank.values();
        Arrays.sort(values, Collections.reverseOrder());

        System.out.println("당첨 통계\n ---------");
        for (LottoRank lottoRank : values) {
            printMatch(lottoRank, result.get(lottoRank));
        }
    }

    public void printRateResult(double rate) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", rate));
    }

    private void printMatch(LottoRank lottoRank, int matchCount) {
        if (!LottoRank.NO_MATCH.equals(lottoRank)) {
            String messageFormat = LottoRank.SECOND.equals(lottoRank) ? SECOND_MESSAGE_FORMAT : DEFAULT_MESSAGE_FORMAT;
            System.out.println(String.format(messageFormat, lottoRank.getMatchCount(), lottoRank.getReward(), matchCount));
        }
    }
}
