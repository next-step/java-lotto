package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_BALL_MIN = 1;
    public static final int LOTTO_BALL_MAX = 45;

    private final List<Integer> lottoBalls = new ArrayList<>();

    public Lotto(Integer[] lottoNumbers) {
        pick(lottoNumbers);
        validateRange();
    }

    private void pick(Integer[] lottoNumbers) {
        for (int i = lottoNumbers.length; i > 0; --i) {
            lottoBalls.add(lottoNumbers[i-1]);
        }
        Collections.sort(lottoBalls);
    }

    private void validateRange() {
        for (Integer ball : lottoBalls) {
            isOutOfRange(ball);
        }
    }

    private void isOutOfRange(Integer ball) {
        if (ball < LOTTO_BALL_MIN || ball > LOTTO_BALL_MAX) {
            throw new IllegalArgumentException("로또를 구성하는 수가 범위를 벗어났습니다.");
        }
    }
}
