package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.domain.LottoNumber.from;

public class WinningLottoNumber {
    private static final String COMMA = ",";

    private List<LottoNumber> values;

    public WinningLottoNumber(String playerInput) {
        parseValues(playerInput);
    }

    public LottoResult decidePrize(LottoGames lottoGames) {
        LottoResult lottoResult = new LottoResult();

        for (int i = 0; i < lottoGames.size(); i++) {
            LottoGame lottoGame = lottoGames.get(i);
            Rank rank = decidePrizeEachGame(lottoGame);
            lottoResult.put(rank);
        }

        return lottoResult;
    }

    private void parseValues(String playerInput) {
        this.values = Arrays.stream(playerInput.split(COMMA))
                .map(each -> from(parseInt(each)))
                .collect(Collectors.toList());
    }

    private Rank decidePrizeEachGame(LottoGame lottoGame) {
        int result = 0;

        for (LottoNumber lottoNumber : values) {
            result = (lottoGame.find(lottoNumber) ? result + 1 : result);
        }

        return Rank.valueOf(result);
    }
}
