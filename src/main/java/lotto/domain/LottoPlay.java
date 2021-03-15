package lotto.domain;

import java.util.*;

public class LottoPlay {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static List<Integer> LOTTO_NUMBER = new ArrayList<>();
    private Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();

    static {
        for (int number = LOTTO_MIN; number <= LOTTO_MAX; number++) {
            LOTTO_NUMBER.add(number);
        }
    };

    public Map<Integer, List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public void createLotto(int inputBuyAmount) {
        int countLotto = inputBuyAmount / LOTTO_PRICE;

        for (int i = 1; i <= countLotto; i++) {
            lottoNumbers.put(i, createLottoNumber());
        }
    }

    public List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER);
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lottoNumber.add(LOTTO_NUMBER.get(i));
            Collections.sort(lottoNumber);
        }

        return lottoNumber;
    }

    public int getMatchNumbers(List<Integer> lottoNumber, int[] winningNumbers) {
        int countWinnings = 0;

        for (int winningNumber : winningNumbers) {
            if (lottoNumber.contains(winningNumber)) {
                countWinnings++;
            }
        }

        return countWinnings;
    }
}
