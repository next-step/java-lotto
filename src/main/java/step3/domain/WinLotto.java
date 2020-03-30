package step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final String SPLIT_SIGN = ",";
    private Set<Integer> winLottoNumber;

    public WinLotto(String inputValue) {
        Set<Integer> list = setWinnerLottoNumber(inputValue);
        this.winLottoNumber = list;
    }

    public int match(List<Integer> buyLottos) {
        return (int) winLottoNumber.stream()
        .filter(number -> buyLottos
        .contains(number))
        .count();
    }

    private Set<Integer> setWinnerLottoNumber(String inputValue) {
        Set<Integer> winnerLottoNumber = new HashSet<>();
        String[] splitString = split(inputValue);
        for (int i = 0; i < splitString.length; i++) {
            int winnerNumber = validateWinnerNumber(splitString[i]);
            winnerLottoNumber.add(winnerNumber);
        }
        checkDuplicate(winnerLottoNumber);

        return winnerLottoNumber;
    }

    private void checkDuplicate(Set<Integer> winnerLottoNumber) {
        if (winnerLottoNumber.size() < 6) {
            throw new IllegalArgumentException("중복된 값이 들어있습니다.");
        }
    }

    private String[] split(String inputValue) {
        String[] splitString;
        try {
            splitString = inputValue.split(SPLIT_SIGN);
            if (splitString.length != 6) {
                throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return splitString;
    }

    private int validateWinnerNumber(String splitString) {
        int winnerNumber = Integer.parseInt(splitString);
        if (winnerNumber > LOTTO_END_NUMBER || winnerNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
        }
        return winnerNumber;
    }
}
