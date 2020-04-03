package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WinningLottos {
    private static final String SECOND_NAME = "2등";
    private static final int MIN_WIN_MATCH_COUNT = LottoRule.MIN_WIN_MATCH_COUNT.getValue();

    private final Map<String, WinningLotto> winningLottoGroup;

    public WinningLottos(WinningLottoInfo winningLottoInfo,
                         LottoTicket lottoTicket) {
        this.winningLottoGroup = getWinningLottos(winningLottoInfo, lottoTicket);
    }

    public Map<String, WinningLotto> getWinningLottos(WinningLottoInfo winningLottoInfo,
                                                      LottoTicket lottoTicket) {
        Map<String, WinningLotto> winningLottos = new HashMap<>();
        Set<LottoNo> winningNums = winningLottoInfo.getWinningNumbers().getNumbers();
        for (int i = 0; i < lottoTicket.getLottoNumbers().size(); i++) {
            int matchCount = 0;
            Set<LottoNo> purchaseNumbers = lottoTicket.getLottoNumbers().get(i).getNumbers();
            matchCount = repeatByWinNumberSize(winningNums, matchCount, purchaseNumbers);
            boolean matchBonus = checkMatchBonusBall(winningLottoInfo, purchaseNumbers);

            addWinningLotto(winningLottos, matchCount, matchBonus);
        }
        return Collections.unmodifiableMap(winningLottos);
    }

    public String winningResult() {
        String result = "당첨통계\n---------\n";
        Rank[] values = Rank.values();
        for (Rank value : values) {
            String key = value.getName();
            int matchCount = value.getMatchCount();
            int resultCount = getResultCount(key);
            result = getResultByRank(result, value, key, matchCount, resultCount);

        }

        return result;
    }

    public String revenuePercent(LottoTicket lottoTicket) {
        String result = "총 수익률은 ";
        double revenuePercent = calculateRevenuePercent(totalWinningAmount(),
                                                        lottoTicket.totalPurchaseAmount());
        result += revenuePercent + "입니다.";
        if (revenuePercent < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        return result;
    }

    public double calculateRevenuePercent(int totalWinningAmount, int totalPurchaseAmount) {
        double revenuePercent = totalWinningAmount / (double) totalPurchaseAmount;
        double decimalPoint = Math.pow(10.0, 2);

        return Math.floor(revenuePercent * decimalPoint) / decimalPoint;
    }

    public int totalWinningAmount() {
        int totalWinningAmount = 0;
        for (String name : this.winningLottoGroup.keySet()) {
            totalWinningAmount += this.winningLottoGroup.get(name).getTotalAmount();
        }
        return totalWinningAmount;
    }

    public boolean checkMatchBonusBall(WinningLottoInfo winningLottoInfo, Set<LottoNo> lottoNumber) {
        boolean matchFlag = false;

        if (lottoNumber.contains(winningLottoInfo.getBonusBall())) {
            matchFlag = true;
        }
        return matchFlag;
    }

    public String getResultByRank(String result, Rank value, String key, int matchCount, int resultCount) {
        if (SECOND_NAME.equals(key)) {
            result += matchCount + "개 일치, 보너스 볼 일치(" + value.getWinningAmount() + "원)- " + resultCount
                      + "개\n";
            return result;
        }
        result += matchCount + "개 일치(" + value.getWinningAmount() + "원)- " + resultCount + "개\n";

        return result;
    }

    private void addWinningLotto(Map<String, WinningLotto> winningLottos, int matchCount, boolean matchBonus) {
        if (matchCount < MIN_WIN_MATCH_COUNT) {
            return;
        }
        if (!winningLottos.containsKey(matchCount)) {
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            winningLottos.put(rank.getName(), new WinningLotto(rank.getWinningAmount(), 1));
            return;
        }

        WinningLotto winningLotto = winningLottos.get(matchCount);
        winningLotto.addCount();

    }

    private int repeatByWinNumberSize(Set<LottoNo> winningNums, int matchCount, Set<LottoNo> purchaseNumbers) {
        for (LottoNo winningNum : winningNums) {
            matchCount = checkContainsWinNumber(matchCount, purchaseNumbers, winningNum);
        }
        return matchCount;
    }

    private int checkContainsWinNumber(int matchCount, Set<LottoNo> purchaseNumbers, LottoNo winningNum) {
        if (purchaseNumbers.contains(winningNum)) {
            ++matchCount;
        }
        return matchCount;
    }

    private int getResultCount(String name) {
        int resultCount = 0;
        if (this.winningLottoGroup.containsKey(name)) {
            resultCount = this.winningLottoGroup.get(name).getCount();
        }
        return resultCount;
    }

    public Map<String, WinningLotto> getWinningLottoGroup() {
        return winningLottoGroup;
    }
}
