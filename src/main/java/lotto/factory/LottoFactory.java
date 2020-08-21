package lotto.factory;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.Lotto;
import lotto.input.InputValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoFactory {

	private static final String WINNING_NUMBER_DELIMITER = ",";
	private static final int LOTTO_BALL_COUNT = 6;
	private static final int TOTAL_COUNT_OF_LOTTO_BALL = 45;
	private static final List<Integer> LOTTO_BALLS = IntStream.range(0, TOTAL_COUNT_OF_LOTTO_BALL)
															  .mapToObj(order -> order + 1)
															  .collect(Collectors.toList());

	private static Random random = new Random();

	public static Lotto create() {
		List<Integer> lottoNumbers = createNumbers();
		return Lotto.of(lottoNumbers);
	}

	public static Lotto create(String lottoNumbersString) {
		return numbersStringToLotto(lottoNumbersString);
	}

	public static Lotto numbersStringToLotto(String numbersString) {
		InputValidator.validateLottoNumbers(numbersString);

		return Lotto.of(Stream.of(numbersString.split(WINNING_NUMBER_DELIMITER))
							  .mapToInt(number -> stringToInt(number))
							  .boxed()
							  .collect(toList()));
	}

	private static List<Integer> createNumbers() {
		List<Integer> allLottoNumbers = getAllShuffled();

		return IntStream.range(0, LOTTO_BALL_COUNT)
						.mapToObj(order -> {
							int orderToGet = random.nextInt(allLottoNumbers.size());
							return allLottoNumbers.remove(orderToGet);
						})
						.collect(Collectors.toList());
	}

	private static List<Integer> getAllShuffled() {
		List<Integer> copiedLottoBalls = LOTTO_BALLS.stream()
													.collect(Collectors.toList());
		Collections.shuffle(copiedLottoBalls);

		return copiedLottoBalls;
	}

	private static Lotto toLotto(List<Integer> numbers) {
		return Lotto.of(numbers);
	}

	private static int stringToInt(String value) {
		String trimValue = value.trim();
		if (!InputValidator.isNumber(trimValue)) {
			throw new IllegalArgumentException("생성할 로또 번호는 숫자로 입력해주세요.");
		}
		return Integer.parseInt(trimValue);
	}
}
