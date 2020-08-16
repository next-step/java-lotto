package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WinningInfos {
    private final List<WinningInfo> winningInfos;

    public static WinningInfos of() {
        List<WinningInfo> list = new ArrayList<>();
        list.add(WinningInfo.of(LottoWinningType.FORTH_WINNING));
        list.add(WinningInfo.of(LottoWinningType.THIRD_WINNING));
        list.add(WinningInfo.of(LottoWinningType.SECOND_WINNING));
        list.add(WinningInfo.of(LottoWinningType.FIRST_WINNING));
        return new WinningInfos(list);
    }

    private WinningInfos(List<WinningInfo> winningInfos) {
        this.winningInfos = winningInfos;
    }

    public List<WinningInfo> getWinningInfos() {
        return winningInfos;
    }

    public void add(LottoWinningType winningType) {
        if (winningType.equals(LottoWinningType.NOTHING)) {
            return;
        }
        WinningInfo winningInfo = winningInfos.stream()
                .filter(e -> e.getWinningType().equals(winningType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        winningInfo.increaseHitNumber();
    }

    public BigDecimal getTotalWinningMoney() {
        return winningInfos.stream()
                .map(e -> e.getWinningType()
                        .getLottoMoney()
                        .multiply(e.getWinningNumber()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
