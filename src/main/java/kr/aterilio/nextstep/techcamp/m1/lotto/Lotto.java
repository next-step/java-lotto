package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_BALL_MIN = 1;
    public static final int LOTTO_BALL_MAX = 45;

    private static final int LOTTO_ELEMENT_COUNT = 6;

    private static final String MSG_ERR_OUT_OF_RANGE = "로또를 구성하는 수가 범위를 벗어났습니다.";
    private static final String MSG_ERR_DUPLICATE = "로또를 구성하는 수 중에 중복된 값이 있습니다.";
    private static final String MSG_ERR_REQUIRED_ELEMENT_COUNT = "입력된 요소는 " + LOTTO_ELEMENT_COUNT + "개 여야 합니다.";

    private final List<Integer> lottoBalls = new ArrayList<>();

    public Lotto(Integer[] lottoNumbers) {
        pick(lottoNumbers);
        validateRange();
        validateDuplicate();
    }

    public int matchCount(Lotto that) {
        List<Integer> matches = new ArrayList<>(this.lottoBalls);
        matches.retainAll(that.lottoBalls);
        return matches.size();
    }

    private void pick(Integer[] lottoNumbers) {
        validateElementCount(lottoNumbers);
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
            throw new IllegalArgumentException(MSG_ERR_OUT_OF_RANGE);
        }
    }

    private void validateDuplicate() {
        Set<Integer> distinct = new HashSet<>(lottoBalls);
        if (distinct.size() != lottoBalls.size()) {
            throw new IllegalArgumentException(MSG_ERR_DUPLICATE);
        }
    }

    private void validateElementCount(Integer[] elements) {
        if (elements.length != LOTTO_ELEMENT_COUNT) {
            throw new IllegalArgumentException(MSG_ERR_REQUIRED_ELEMENT_COUNT);
        }
    }

    public int count() {
        return lottoBalls.size();
    }
}
