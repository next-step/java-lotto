package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int DEFAULT_SIZE = 6;

    private List<Integer> winningLottoNumbers;

    private WinningLotto(int[] winningLottoNumbers) {
        validateSize(winningLottoNumbers);
        this.winningLottoNumbers = convertToList(winningLottoNumbers);
    }

    public static WinningLotto of(int[] winningLottoNumbers) {
        return new WinningLotto(winningLottoNumbers);
    }


    private List<Integer> convertToList(int[] winningLottoNumbers) {
        List<Integer> winningList = Arrays.stream(winningLottoNumbers).boxed()
                .collect(Collectors.toList());
        validateList(winningList);
        return winningList;
    }

    private void validateSize(int[] winningLottoNumbers) {
        if (winningLottoNumbers.length < DEFAULT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateList(List<Integer> winningLottoNumbers) {
        for (int i = 0; i < winningLottoNumbers.size(); i++) {
            int number = winningLottoNumbers.get(i);
            if (number < LottoNumber.LOTTO_NUMBER_MIN && number > LottoNumber.LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException();
            }
        }
    }
}
