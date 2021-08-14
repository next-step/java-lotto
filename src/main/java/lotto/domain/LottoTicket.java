package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final static int LOTTO_BALLS_MAX_NUM = 6;

    private final Set<LottoBall> lottoBalls;

    private LottoTicket(int... numbers) {
        lottoBalls = Collections.unmodifiableSet(
            Arrays.stream(numbers)
                .mapToObj(LottoBall::select)
                .collect(Collectors.toSet())
        );
        validate();
    }

    public static LottoTicket of(int... numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket createRandomNumber() {
        List<Integer> randomNumbers = IntStream
            .rangeClosed(LottoBall.LOTTO_BALL_NUMBER_MIN, LottoBall.LOTTO_BALL_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);
        randomNumbers = new ArrayList<>(randomNumbers.subList(0, LOTTO_BALLS_MAX_NUM));

        return LottoTicket.of(randomNumbers.stream()
            .mapToInt(Integer::intValue)
            .toArray());
    }

    private void validate() {
        if (lottoBalls.size() != LOTTO_BALLS_MAX_NUM) {
            throw new RuntimeException("로또공의 개수를 만족하지 않습니다.");
        }
    }

    public boolean contains(LottoBall anyLottoBall) {
        return lottoBalls.stream()
            .anyMatch(lottoBall -> lottoBall.equals((LottoBall.select(anyLottoBall.number()))));
    }

    public int countMatchNumber(LottoTicket winnerNumbers) {
        return (int)lottoBalls.stream()
            .filter(winnerNumbers::contains)
            .count();
    }

    public Set<LottoBall> toLottoBallSet() {
        return lottoBalls;
    }
}

