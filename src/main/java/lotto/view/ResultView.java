package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.dto.LottoMatchResult;
import lotto.dto.LottoMatchType;
import lotto.dto.UserLotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printUserLotto(Lotto lotto) {
        UserLotto userLotto = lotto.getUserLotto();

        System.out.println(String.format("%s 개를 구매했습니다.", userLotto.getTickets().size()));

        List<LottoTicket> tickets = userLotto.getTickets();
        for (LottoTicket ticket : tickets) {
            String lottoNumbers = ticket.getTicket().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
            System.out.println("[" + lottoNumbers + "]");
        }
    }

    public static void printLottoMatchResult(LottoMatchResult lottoMatchResult, long money) {
        Map<LottoMatchType, Integer> matchTable = lottoMatchResult.getMatchTable();
        for (LottoMatchType lottoType : matchTable.keySet()) {
            int userMatchCount = matchTable.get(lottoType);
            System.out.println(String.format("%s개 일치 (%s원)- %s개", lottoType.matchCount, lottoType.money,
                    userMatchCount));
        }

        System.out.print(String.format("총 수익률은 %.2f입니다.", lottoMatchResult.getLottoMatchRateOfResult(money)));
    }
}
