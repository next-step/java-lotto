package step3.domain;

import java.util.*;

public class WinLotto extends Lotto{
    private static final int ZERO = 0;
    private LottoNumberList winLottoNumber;
    private LottoNumber bonuseBall;

    public WinLotto(String winNumber, LottoNumber bonusBallInputValue) {
        this.winLottoNumber = checkWinLottoNumber(winNumber);
        this.bonuseBall = addBonusBall(bonusBallInputValue);
    }

    private LottoNumberList checkWinLottoNumber(String winNumber) {
        return setWinnerLottoNumber(winNumber);
    }

    public int match(LottoNumberList buyLottos) {
        return (int) winLottoNumber.getLottoNumberList().stream()
                .filter(number -> buyLottos.isContains(number))
                .count();
    }

    private LottoNumberList setWinnerLottoNumber(String inputValue) {
        List<LottoNumber> winnerLottoNumber = new ArrayList<>();
        String[] splitString = split(inputValue);
        for (int i = 0; i < splitString.length; i++) {
            LottoNumber winnerNumber = LottoNumber.of(Integer.parseInt(splitString[i]));
            winnerLottoNumber.add(winnerNumber);
        }
        checkDuplicate(winnerLottoNumber);
        return new LottoNumberList(winnerLottoNumber);
    }

    private void checkDuplicate(List<LottoNumber> winnerLottoNumber) {
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
        return (int) winLottoNumber.getLottoNumberList().stream()
                .filter(number -> Arrays.asList(bonusBallInputValue).contains(number))
                .count();
    }

    public boolean matchBonusball(LottoNumberList buyLottos) {
        return Arrays.asList(this.bonuseBall)
                .stream()
                .filter(number -> buyLottos.getLottoNumberList().contains(number))
                .findFirst()
                .isPresent();
    }

    @Override
    public String toString() {
        return String.valueOf(winLottoNumber);
    }
}
