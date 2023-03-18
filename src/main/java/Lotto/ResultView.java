package Lotto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private final Lottos lottos;

    public ResultView(Lottos lottos) {
        this.lottos = lottos;
    }

    private Map<LottoRank, Integer> ranks;

    public void printWinResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        setRanks();
        for (Map.Entry<LottoRank, Integer> ranks : ranks.entrySet()) {
            System.out.println(String.format("%s개 일치 %s - %s개", ranks.getKey().getHitCount(), ranks.getKey().getDescription(), ranks.getValue()));
        }
        System.out.println("총 수익률은 " + String.valueOf(lottos.getRate()) + "입니다.");
    }

    private Map<LottoRank, Integer> setRanks() {
        ranks = new TreeMap<LottoRank, Integer>();
        ranks.put(LottoRank.FIFTH_RANK, 0);
        ranks.put(LottoRank.FOURTH_RANK, 0);
        ranks.put(LottoRank.THIRD_RANK, 0);
        ranks.put(LottoRank.SECOND_RANK, 0);
        ranks.put(LottoRank.FIRST_RANK, 0);
        int count = 0;
        for (int i = 0; i < lottos.getLottoCount(); i++) {
            LottoRank rank = lottos.getLottos().get(i).getRank();
            if (null == rank) continue;

            if (ranks.containsKey(rank)) {
                count = ranks.get(rank) + 1;
            }
            ranks.put(rank, count);
        }
        return ranks;
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getLottoCount(); i++) {
            System.out.println(lottos.getLottos().get(i).getLottoNumbers().toString());
        }
    }

}
