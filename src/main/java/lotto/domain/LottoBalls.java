package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {
	private final static int LOTTO_BALLS_MAX_NUM = 6;

	private final List<LottoBall> lottoBalls;

	private LottoBalls(int... numbers) {
		validate(numbers);
		this.lottoBalls = Arrays.stream(numbers)
			.mapToObj(LottoBall::from)
			.collect(Collectors.toList());
	}

	protected static LottoBalls of(int... numbers) {
		return new LottoBalls(numbers);
	}

	private void validate(int... numbers) {
		if (numbers.length != LOTTO_BALLS_MAX_NUM) {
			throw new RuntimeException("로또공의 개수를 만족하지 않습니다.");
		}
	}

	public static LottoBalls createRandomNumber() {
		List<Integer> randomNumbers = IntStream
			.rangeClosed(LottoBall.LOTTO_BALL_NUMBER_MIN, LottoBall.LOTTO_BALL_NUMBER_MAX)
			.boxed()
			.collect(Collectors.toList());

		Collections.shuffle(randomNumbers);
		randomNumbers = randomNumbers.subList(0, LOTTO_BALLS_MAX_NUM).stream()
			.sorted()
			.collect(Collectors.toList());

		return LottoBalls.of(randomNumbers.stream()
			.mapToInt(Integer::intValue)
			.toArray());
	}

	private boolean contains(int number) {
		return lottoBalls.stream()
			.anyMatch(lottoBall -> lottoBall.equals((new LottoBall(number))));
	}

	public int countMatchNumber(int... winnerNumbers) {
		return (int) Arrays.stream(winnerNumbers)
			.filter(this::contains)
			.count();
	}

	@Override
	public String toString() {
		return "[" + lottoBalls.stream().map(LottoBall::toString)
			.collect(Collectors.joining(", ")) + "]";
	}
}
