package step3.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private int totalWinningPrice;
    private Map winningMap;
    private Lotto winningLotto;
    private LottoNumber bonusBall;


    public WinningStatistics(List<Lotto> lottoList, Lotto winningLotto, LottoNumber bonusBall) {
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
        if (matchBonus(winningLotto)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에서 제외되어야 합니다.");
        }
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getLottoNumber().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public Map<WinningPrice, Integer> makeWinningMap() {
        initWinningMap();
        for (Lotto lotto : lottoList) {
            putWinningMap(lotto);
        }
        winningMap.remove(WinningPrice.OTHER);
        return winningMap;
    }

    private void initWinningMap() {
        winningMap = new EnumMap(WinningPrice.class);
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningMap.put(winningPrice, 0);
        }
    }

    private void putWinningMap(Lotto lotto) {
        winningMap.put(WinningPrice.valueOf(winningCount(lotto), matchBonus(lotto)), (int) winningMap.get(WinningPrice.valueOf(winningCount(lotto), matchBonus(lotto))) + 1);
    }

    public int winningCount(Lotto lotto) {
        return (int) lotto.getLottoNumber().stream()
                .filter(number -> winningLotto.getLottoNumber().contains(number))
                .count();
    }

    public boolean isBenefit() {
        return getWinningStatic() > (float) 1;
    }

    public float getWinningStatic() {
        totalWinningPrice = getTotalWinningPrice();
        if (lottoList.size() == 0) {
            return 0;
        }
        return (float) totalWinningPrice / (LottoFactory.LOTTO_PRICE * lottoList.size());
    }

    public int getTotalWinningPrice() {
        return lottoList.stream()
                .mapToInt(lotto -> WinningPrice.valueOf(winningCount(lotto), matchBonus(lotto)).getPrice())
                .sum();
    }
}
