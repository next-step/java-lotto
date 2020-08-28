package domain;

import java.util.*;
import java.util.stream.Collectors;

import static domain.LottoMoney.MONEY_PER_GAME;

public class LottoGame {
    private final List<Lotto> lottos;

    protected LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGame of(int money) {
        List<Lotto> lottoList = generateLottoNumbersList(money);
        return new LottoGame(lottoList);
    }

    private static List<Lotto> generateLottoNumbersList(int money) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        int gameCount = money / MONEY_PER_GAME;

        for (int i = 0; i < gameCount; i++) {
            lottoNumbers.add(Lotto.auto());
        }

        return lottoNumbers;
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
