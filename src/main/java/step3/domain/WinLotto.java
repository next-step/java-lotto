package step3.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {
    private static final int ZERO = 0;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int SELECT_NUMBER = 6;
    private static final String SPLIT_SIGN = ",";
    private Set<LottoNumber> winLottoNumber;
    private LottoNumber bonuseBall;

    public WinLotto(String winNumber, LottoNumber bonusBallInputValue) {
        this.winLottoNumber = checkWinLottoNumber(winNumber);
        this.bonuseBall = addBonusBall(bonusBallInputValue);
    }

    public static int getSelectNumber() {
        return SELECT_NUMBER;
    }

    private Set<LottoNumber> checkWinLottoNumber(String winNumber) {
        return setWinnerLottoNumber(winNumber);
    }

    public int match(LottoNumberList buyLottos) {
        return (int) winLottoNumber.stream()
                .filter(number -> buyLottos.contains(number))
                .count();
    }

    private Set<LottoNumber> setWinnerLottoNumber(String inputValue) {
        Set<LottoNumber> winnerLottoNumber = new HashSet<>();
        String[] splitString = split(inputValue);
        for (int i = 0; i < splitString.length; i++) {
            LottoNumber winnerNumber = new LottoNumber(Integer.parseInt(splitString[i]));
            winnerLottoNumber.add(winnerNumber);
        }
        checkDuplicate(winnerLottoNumber);
        return winnerLottoNumber;
    }

    private void checkDuplicate(Set<LottoNumber> winnerLottoNumber) {
        if (winnerLottoNumber.size() < SELECT_NUMBER) {
            throw new IllegalArgumentException("중복된 값이 들어있습니다.");
        }
    }

    private String[] split(String inputValue) {
        String[] splitString;
        try {
            splitString = inputValue.split(SPLIT_SIGN);
            if (splitString.length != SELECT_NUMBER) {
                throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return splitString;
    }

    public LottoNumber addBonusBall(LottoNumber bonusBallInputValue) {
        int sameCount = match(bonusBallInputValue);
        if (sameCount > ZERO) {
            throw new IllegalArgumentException("보너스볼은 당첨번호의 값과 중복이 되면 안됩니다.");
        }
        return bonusBallInputValue;
    }

    private int match(LottoNumber bonusBallInputValue) {
        return (int) winLottoNumber.stream()
                .filter(number -> Arrays.asList(bonusBallInputValue).contains(number))
                .count();
    }

    public boolean matchBonusball(LottoNumberList buyLottos) {
        int matchCount = (int) Arrays.asList(this.bonuseBall)
                .stream()
                .filter(number -> buyLottos.contains(number))
                .count();
        if (matchCount == 1) {
            return true;
        }
        return false;
    }
}
