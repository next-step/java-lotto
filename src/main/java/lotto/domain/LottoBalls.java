package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoBalls {
    public static final int LOTTO_BALL_VALID_COUNT = 6;
    private final Set<LottoNumber> balls = new TreeSet<>();

    public LottoBalls(Collection<Integer> balls) {
        this.balls.addAll(balls.stream().map(LottoNumber::new).collect(Collectors.toSet()));
        validate();
    }

    public LottoBalls(Integer... balls) {
        this(Arrays.asList(balls));
    }

    private void validate() {
        if(balls.size() != LOTTO_BALL_VALID_COUNT){
            throw new RuntimeException(String.format(ErrorMessage.INVALID_BALL_COUNT, LOTTO_BALL_VALID_COUNT));
        }
    }

    @Override
    public String toString() {
        return balls.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public int containsCount(LottoBalls lottoBalls) {
        return (int) balls.stream().filter(lottoBalls.balls::contains).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBalls that = (LottoBalls) o;
        return balls.containsAll(that.balls) && that.balls.containsAll(balls);
    }
}
