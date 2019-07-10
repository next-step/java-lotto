package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNumber {
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int EXIST_BONUS_BALL = 1;

    private ArrayList<Integer> lottoElement = new ArrayList<>();

    // 생성자를 호출하면 lottoElement에 로또번호를 생성하여 추가
    LottoNumber() {
        ArrayList<Integer> randomNumber = getRandomNumber();

        for (int i = 0; i < ONE_UNIT_OF_LOTTO; i++) {
            lottoElement.add(randomNumber.get(i));
        }
    }

    public LottoNumber(int[] temp){
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; i++) {
            lottoElement.add(temp[i]);
        }
    }

    public ArrayList<Integer> getElement() {
        return lottoElement;
    }

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교
    int compareWinningNumber(int[] winningLottoNumber, int bonusball) {
        int wingingCount = 0;
        for (int value : winningLottoNumber) {
            wingingCount = lottoElement.contains(value) ? wingingCount + 1 : wingingCount;
        }

        return checkBonusBall(bonusball, wingingCount);
    }

    private ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);
        return randomNumber;
    }

    private int checkBonusBall(int bonusball, int countsResult) {
        if ((countsResult == LottoRankData.THIRD_WINNER.getMatch() && lottoElement.contains(bonusball))) {
            countsResult = 0; // 보너스 볼을 포함하는 4등 카운트 초기화
            LottoRankData.setBonusBallCount(EXIST_BONUS_BALL);
        }
        return countsResult;
    }
}
