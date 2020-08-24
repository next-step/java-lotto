package step2.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private int totalWinningPrice;
    private Map winningMap;
    private Lotto winningLotto;

    public WinningStatistics(List<Lotto> lottoList, Lotto winningLotto) {
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
    }

    public WinningStatistics(List<Lotto> lottoList) {
        this(lottoList, new Lotto(new ArrayList<>()));
    }

    public Map<WinningPrice, Integer> makeWinningMap() {
        initWinningMap();
        for (Lotto lotto : lottoList) {
            winningMap.put(WinningPrice.valueOf(winningCount(lotto)), (int) winningMap.get(WinningPrice.valueOf(winningCount(lotto))) + 1);
        }
        winningMap.remove(WinningPrice.OTHER);
        return winningMap;
    }

    public int winningCount(Lotto lotto) {
        return (int) lotto.getLottoNumber().stream()
                .filter(number -> winningLotto.getLottoNumber().contains(number))
                .count();
    }

    public void initWinningMap() {
        winningMap = new EnumMap(WinningPrice.class);
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningMap.put(winningPrice, 0);
        }
    }

    public boolean isBenefit() {
        return getWinningStatic() > (float) 1;
    }

    public float getWinningStatic() {
        totalWinningPrice = getTotalWinningPrice();
        if (lottoList.size() == 0) {
            return 0;
        }
        return (float) totalWinningPrice / (MakeLottoFactory.LOTTO_PRICE * lottoList.size());
    }

    public int getTotalWinningPrice() {
        return lottoList.stream()
                .mapToInt(lotto -> WinningPrice.valueOf(winningCount(lotto)).getPrice())
                .sum();
    }
}
