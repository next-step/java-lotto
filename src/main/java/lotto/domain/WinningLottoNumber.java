package lotto.domain;

import lotto.exception.WinningLottoNonPositiveNumberException;
import lotto.exception.WinningLottoNumberCountException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.valueOf;

public class WinningLottoNumber {
    private static final String COMMA = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");

    private List<LottoNumber> values;

    public WinningLottoNumber(String playerInput) {
        validatePlayerInput(playerInput);
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

    private void validatePlayerInput(String playerInput) {
        validatePositiveNumber(playerInput);
        validateInputSize(playerInput);
    }

    private void validatePositiveNumber(String playerInput) {
        Matcher numberArrayCheckResult = NUMBER_PATTERN.matcher(playerInput);
        if (!numberArrayCheckResult.find()) {
            throw new WinningLottoNonPositiveNumberException();
        }
    }

    private void validateInputSize(String playerInput) {
        String[] tempPlayerInputArray = playerInput.split(",");
        List<String> tempPlayerInputList = Arrays.asList(tempPlayerInputArray);
        Set<String> playerInputSetForSizeCheck = new HashSet<>(tempPlayerInputList);

        if (playerInputSetForSizeCheck.size() != LOTTO_NUMBER_COUNT) {
            throw new WinningLottoNumberCountException();
        }
    }

    private void parseValues(String playerInput) {
        this.values = Arrays.stream(playerInput.split(COMMA))
                .map(each -> valueOf(parseInt(each)))
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
