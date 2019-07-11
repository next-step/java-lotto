package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {
    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int EXIST_BONUS_BALL = 1;

    private ArrayList<Integer> lottoElement = new ArrayList<>();

    // 생성자를 호출하면 lottoElement에 로또번호를 생성하여 추가
    public LottoNumber(List<Integer> input) {
        IntStream.range(0, ONE_UNIT_OF_LOTTO)
                .forEach(i -> lottoElement.add(input.get(i)));
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

        return matchBonusBall(bonusball, wingingCount);
    }

    private int matchBonusBall(int bonusball, int countsResult) {
        if ((countsResult == LottoRankData.THIRD_WINNER.getMatch() && lottoElement.contains(bonusball))) {
            countsResult = 0; // 보너스 볼을 포함하는 4등 카운트 초기화
            LottoRankData.setBonusBallCount(EXIST_BONUS_BALL);
        }
        return countsResult;
    }
}
