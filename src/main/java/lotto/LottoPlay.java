package lotto;

import java.util.*;

public class LottoPlay {
    private static List<Integer> LOTTO_NUMBER = new ArrayList<>();
    private Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LOTTO_NUMBER.add(i);
        }
    };

    public Map<Integer, List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public void createLotto(int input) {
        int countLotto = input/1000;

        for (int i = 1; i <= countLotto; i++) {
            lottoNumbers.put(i, createLottoNumber(countLotto));
        }
    }

    public List<Integer> createLottoNumber(int countLotto) {
        List<Integer> lottoNumber = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER);
        for (int i = 0; i < countLotto; i++) {
            lottoNumber.add(i);
            Collections.sort(lottoNumber);
        }

        return lottoNumber;
    }

    public int getWinningNumbers(List<Integer> lottoNumber, int[] winningNumbers) {
        int countWinnings = 0;

        for (int winningNumber : winningNumbers) {
            if (lottoNumber.contains(winningNumber)) {
                countWinnings++;
            }
        }

        return countWinnings;
    }
}
