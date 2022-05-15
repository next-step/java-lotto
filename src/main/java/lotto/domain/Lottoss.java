package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;

public class Lottoss {
    public static final int LOTTO_UNIT_NUMBER = 6;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;

    private final Integer[][] lottoNumber;
    private HashMap<String, Integer> Winners = new HashMap<>();

    public Lottoss(int lottoOfNumber) {
        this.lottoNumber = new Integer[lottoOfNumber][LOTTO_UNIT_NUMBER];
        for (int i = 0; i < lottoOfNumber; i++) {
            generateLotto(i);
        }
    }

    public Lottoss(Integer[][] lottoNumber) {
        this.lottoNumber = lottoNumber;

    }


    private void generateLotto(int rowIndex) {
        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            lottoNumber[rowIndex][i] = ((int) (Math.random() * LOTTO_MAX_NUMBER)) + LOTTO_MINIMUM_NUMBER;
        }
    }


    public void findWinners(Integer[] answer) {
        for (int i = 0; i < lottoNumber.length; i++) {
            int count = 0;
            for (int j = 0; j < LOTTO_UNIT_NUMBER; j++) {
                if (Arrays.asList(answer).contains(lottoNumber[i][j])) {
                    count++;
                }
            }
            if (count >= 3) {
                Winners.put(count + "개", Winners.getOrDefault(count + "개", 0) + 1);
            }
        }
    }

    public HashMap<String, Integer> getWinners() {
        return Winners;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(lottoNumber);
    }

}
