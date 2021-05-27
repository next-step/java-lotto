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

    public WinningLottoNumber(String prizeLottoNumberInput) {
        validateConstructor(prizeLottoNumberInput);
        parseValues(prizeLottoNumberInput);
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

    public void applyBonusNumber(String bonusNumberInput) {
        validateAlreadySet();
        validateBonusNumber(bonusNumberInput);

        this.bonusLottoNumber = LottoNumber.valueOf(parseInt(bonusNumberInput));
    }

    private void validateConstructor(String prizeLottoNumberInput) {
        validatePositiveNumber(prizeLottoNumberInput);
        validateInputSize(prizeLottoNumberInput);
    }

    private void validatePositiveNumber(String prizeLottoNumberInput) {
        Matcher numberArrayCheckResult = NUMBER_PATTERN.matcher(prizeLottoNumberInput);
        if (!numberArrayCheckResult.find()) {
            throw new WinningLottoNonPositiveNumberException();
        }
    }

    private void validateInputSize(String prizeLottoNumberInput) {
        String[] tempPrizeLottoNumberArray = prizeLottoNumberInput.split(",");
        List<String> tempPrizeLottoNumberList = Arrays.asList(tempPrizeLottoNumberArray);
        Set<String> tempPrizeLottoNumberSetForSizeCheck = new HashSet<>(tempPrizeLottoNumberList);

        if (tempPrizeLottoNumberSetForSizeCheck.size() != LOTTO_NUMBER_COUNT) {
            throw new WinningLottoNumberCountException();
        }
    }

    private void validateAlreadySet() {
        if (bonusLottoNumber != null) {
            throw new AlreadyAppliedBonusNumberException();
        }
    }

    private void validateBonusNumber(String bonusNumberInput) {
        LottoNumber tempBonusNumber = valueOf(Integer.parseInt(bonusNumberInput));

        if (prizeLottoNumber.find(tempBonusNumber)) {
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
