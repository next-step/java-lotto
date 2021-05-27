package lotto.domain;

import lotto.exception.AlreadyAppliedBonusNumberException;
import lotto.exception.DuplicatedBonusNumberException;
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

    private LottoGame prizeLottoNumber;
    private LottoNumber bonusLottoNumber;

    public WinningLottoNumber(String playerInput) {
        validateConstructor(playerInput);
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

    public void applyBonusNumber(String playerInput) {
        validateAlreadySet(playerInput);
        validateBonusNumber(playerInput);

        this.bonusLottoNumber = LottoNumber.valueOf(parseInt(playerInput));
    }

    private void validateConstructor(String playerInput) {
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

    private void validateAlreadySet(String playerInput) {
        if (bonusLottoNumber != null) {
            throw new AlreadyAppliedBonusNumberException();
        }
    }

    private void validateBonusNumber(String playerInput) {
        LottoNumber tempLottoNumber = valueOf(Integer.parseInt(playerInput));

        if (prizeLottoNumber.find(tempLottoNumber)) {
            throw new DuplicatedBonusNumberException();
        }
    }

    private void parseValues(String playerInput) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(playerInput.split(COMMA))
                .map(each -> valueOf(parseInt(each)))
                .collect(Collectors.toSet());

        prizeLottoNumber = LottoGame.createManual(lottoNumbers);
    }

    private Rank decidePrizeEachGame(LottoGame lottoGame) {
        int prizeResult = prizeLottoNumber.compare(lottoGame);
        int bonusNumberResult = (lottoGame.find(bonusLottoNumber) ? 1 : 0);
        return Rank.valueOf(prizeResult, bonusNumberResult);
    }
}
