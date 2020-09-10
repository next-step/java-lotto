package domain;

import java.util.*;
import java.util.stream.Collectors;

import static domain.LottoMoney.MONEY_PER_GAME;
import static java.util.stream.Collectors.toList;

public class LottoGame {
    private final List<Lotto> lottos;

    protected LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGame of(int money, List<String> manualLottosRaw) {
        List<Lotto> manualLottos = getManualLottos(manualLottosRaw);
        List<Lotto> lottos = getLottosOfGame(money, manualLottos);
        return new LottoGame(lottos);
    }

    private static List<Lotto> getManualLottos(List<String> manualLottosRaw) {
        return manualLottosRaw.stream()
                .map(Lotto::manualLotto)
                .collect(toList());
    }

    private static List<Lotto> getLottosOfGame(int money, List<Lotto> manualLottos) {
        int gameCount = money / MONEY_PER_GAME;
        int autoCount = gameCount - manualLottos.size();
        return getAutoLottos(manualLottos, autoCount);
    }

    public static List<Lotto> getAutoLottos(List<Lotto> manualLotto, int gameCount) {
        List<Lotto> lottos = new ArrayList<>(manualLotto);
        for (int i = 0; i < gameCount; i++) {
            lottos.add(Lotto.auto());
        }
        return lottos;
    }

    protected List<Lotto> getLottos() {
        return lottos;
    }

    public WinningInfos getWinningInfos(String winningNumberStr, String bonusLottoNumber) {
        WinningLotto winningLotto = WinningLotto.of(winningNumberStr, bonusLottoNumber);
        return getWinningInfos(winningLotto);
    }

    protected WinningInfos getWinningInfos(WinningLotto winningLotto) {
        WinningInfos winningInfos = WinningInfos.of();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto, winningLotto);
            winningInfos.update(rank);
        }
        return winningInfos;
    }

    @Override public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
