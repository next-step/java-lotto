package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> purchaseLotto(Money money) {
        List<Lotto> lottoGames = new ArrayList<>();
        for (int i = 0; i < money.getGameCount(); i++) {
            lottoGames.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }

        return lottoGames;
    }

    public WinningStatus match(List<Lotto> lottoGames, WinningNumber winningNumber) {
        return new WinningStatus(lottoGames, winningNumber);
    }
}
