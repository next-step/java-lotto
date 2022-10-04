package lotto.service;

import lotto.model.LottoBall;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberPicker {

    public static int LOTTO_LENGTH = 6;

    public static List<LottoBall> pick(List<Integer> candidates) {
        List<LottoBall> balls = candidates.subList(0, LOTTO_LENGTH).stream().map(LottoBall::new).collect(Collectors.toList());
        validateBalls(balls);
        return balls;
    }

    private static void validateBalls(List<LottoBall> balls) {
        int count = Long.valueOf(balls.stream().distinct().count()).intValue();
        if (count != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 추첨번호는 중복되지 않아야 합니다.");
        }
    }

}
