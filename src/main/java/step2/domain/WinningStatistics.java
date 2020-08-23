package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private int totalWinningPrice;
    private Map winningMap;

    public WinningStatistics(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getTotalWinningPrice() {
        return lottoList.stream()
                .map(Lotto::getWinningPrice)
                .mapToInt(WinningPrice::getPrice)
                .sum();
    }

    public float getWinningStatic() {
        totalWinningPrice = getTotalWinningPrice();
        if (lottoList.size() == 0) {
            return 0;
        }
        return (float) totalWinningPrice / (MakeLottoFactory.LOTTO_PRICE * lottoList.size());
    }

    public boolean isBenefit() {
        return getWinningStatic() > (float) 1;
    }

    public Map<WinningPrice, Integer> makeWinningMap() {
        initWinningMap();
        for (Lotto lotto : lottoList) {
            winningMap.put(lotto.getWinningPrice(), (int) winningMap.get(lotto.getWinningPrice()) + 1);
        }
        winningMap.remove(WinningPrice.OTHER);
        return winningMap;
    }

    public void initWinningMap() {
        winningMap = new EnumMap(WinningPrice.class);
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningMap.put(winningPrice, 0);
        }
    }
}
