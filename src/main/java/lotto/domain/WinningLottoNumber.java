package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.*;

public class WinningLottoNumber {
    private static final String MESSAGE_POSITIVE_NUMBER_ONLY = "당첨 번호는 양수만 입력할 수 있습니다.";
    private static final String MESSAGE_REQUEST_VALID_LOTTO_COUNT = "당첨 번호는 중복 되지 않는 %d에서" +
            " %d 사이의 번호 %d자리를 입력 해야 합니다.";
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
            throw new IllegalArgumentException(MESSAGE_POSITIVE_NUMBER_ONLY);
        }
    }

    private void validateInputSize(String playerInput) {
        String[] tempPlayerInputArray = playerInput.split(",");
        List<String> tempPlayerInputList = Arrays.asList(tempPlayerInputArray);
        Set<String> playerInputSetForSizeCheck = new HashSet<>(tempPlayerInputList);
        
        if (playerInputSetForSizeCheck.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(format(MESSAGE_REQUEST_VALID_LOTTO_COUNT,
                    MIN_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBER,
                    LOTTO_NUMBER_COUNT));
        }
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
