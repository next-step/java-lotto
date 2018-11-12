package domain;

import util.ParsingUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> purchaseLotto(Money money, List<String> manualNumbers) {
        List<Lotto> lottoGames = new ArrayList<>();

        for (String manualNumber : manualNumbers) {
            lottoGames.add(new Lotto(ParsingUtil.parseStringToIntList(manualNumber), false));
        }

        int autoGameCount = money.getGameCount() - manualNumbers.size();
        for (int i = 0; i < autoGameCount; i++) {
            lottoGames.add(new Lotto(LottoNumberGenerator.generateNumbers(), true));
        }

        return lottoGames;
    }

    public WinningStatus match(List<Lotto> lottoGames, WinningNumber winningNumber) {
        return new WinningStatus(lottoGames, winningNumber);
    }
}
