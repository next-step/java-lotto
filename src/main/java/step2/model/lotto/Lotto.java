package step2.model.lotto;

import static java.util.stream.IntStream.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import step2.exception.BadRequestException;
import step2.util.NumberUtil;

public class Lotto {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;
	private static final List<Integer> AVAILABLE_NUMBERS = range(MIN_NUMBER, MAX_NUMBER + 1).boxed()
		.collect(Collectors.toList());

	private final List<Integer> numbers;

	public Lotto() {
		shuffle();
		numbers = pick();
		Collections.sort(numbers);
	}

	public Lotto(List<Integer> numbers) {
		checkLottoSize(numbers);
		checkDuplicatedNumbers(numbers);
		checkRange(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public int getMatchCount(List<Integer> values) {
		return (int)values.stream()
			.filter(numbers::contains).count();
	}

	private void shuffle() {
		Collections.shuffle(AVAILABLE_NUMBERS);
	}

	private List<Integer> pick() {
		return range(0, LOTTO_SIZE)
			.mapToObj(AVAILABLE_NUMBERS::get)
			.collect(Collectors.toList());
	}

	private void checkLottoSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new BadRequestException("6개의 당첨 번호를 입력해주세요.");
		}
	}

	private void checkDuplicatedNumbers(List<Integer> numbers) {
		Set<Integer> numbersSet = new HashSet<>(numbers);
		if (numbersSet.size() != numbers.size()) {
			throw new BadRequestException("로또 번호는 중복될 수 없습니다.");
		}

		for (Integer number : numbers) {
			if (NumberUtil.isOver(number, MAX_NUMBER) || NumberUtil.isUnder(number, MIN_NUMBER)) {
				throw new BadRequestException("로또 번호는 1 ~ 45 범위 내에 있어야 합니다.");
			}
		}
	}

	private void checkRange(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (NumberUtil.isOver(number, MAX_NUMBER) || NumberUtil.isUnder(number, MIN_NUMBER)) {
				throw new BadRequestException("로또 번호는 1 ~ 45 범위 내에 있어야 합니다.");
			}
		}
	}
}
