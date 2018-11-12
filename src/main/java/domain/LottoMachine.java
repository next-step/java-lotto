package domain;

import util.ParsingUtil;

import java.util.List;

public class LottoMachine {

    public LottoGames purchaseLotto(Money money, List<String> manualNumbers) {
        LottoGames lottoGames = new LottoGames();

        for (String manualNumber : manualNumbers) {
            lottoGames.add(new Lotto(ParsingUtil.parseStringToLottoNumbers(manualNumber), false));
        }

        int autoGameCount = money.getGameCount() - manualNumbers.size();
        for (int i = 0; i < autoGameCount; i++) {
            lottoGames.add(new Lotto(LottoNumberGenerator.generateNumbers(), true));
        }

        return lottoGames;
    }

    public WinningStatus match(LottoGames lottoGames, WinningNumber winningNumber) {
        return new WinningStatus(lottoGames, winningNumber);
    }
}
