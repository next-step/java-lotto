package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class WinnerResult {
    private final EnumMap<Rank, Integer> results = new EnumMap<>(Rank.class);
    private final int earningsRate;  // 수익률

    /**
     * @param goldenTicket 당첨 번호 (보너스 볼 포함)
     * @param lottoTickets 구입한 로또들
     */
    public WinnerResult(final GoldenTicket goldenTicket, final List<LottoTicket> lottoTickets) {
        analyze(goldenTicket, lottoTickets);  // 당첨 통계 분석
        earningsRate = 0;
    }

    // TODO: winningTicket은 별도 객체로 분리 (6개의 LottoNumber / 1개의 bonusNumber를 가짐)
    private void analyze(final GoldenTicket goldenTicket, final List<LottoTicket> pickedLottoTickets) {
        for (LottoTicket lottoTicket : pickedLottoTickets) {
            LottoResult result = new LottoResult(goldenTicket, lottoTicket);
            Rank rank = result.getRank();
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    public EnumMap<Rank, Integer> getResults() {
        return results;
    }
}
