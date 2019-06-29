package lotto.model;

import common.NumberElement;
import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberSet {

	private static final CharSequence TO_STRING_DELIMITER = ", ";

	List<LottoNumber> numbers;

	public LottoNumberSet(List<LottoNumber> numbers) {
		numbers.stream().forEach(this::add);
		Collections.sort(this.numbers);
	}


	private void add(LottoNumber number) {

		if(numbers == null){
			this.numbers = new ArrayList<>();
		}

		if(numbers.size() == LottoRule.MAX_COUNT){
			throw new OutOfCountException();
		}

		if(numbers.contains(number)){
			throw new DuplicateNumberException();
		}

		numbers.add(number);

	}


	public int size() {
		return numbers.size();
	}

	public boolean contains(LottoNumber bonus) {
		return this.numbers.contains(bonus);
	}

	/**
	 * 대상 컬렉션과 일치하는 숫자만 포함하는 컬렉션 반환
	 * @param collection
	 * @return
	 */
	public List<NumberElement> matchNumbers(LottoNumberSet collection) {

		List<NumberElement> matched = this.numbers
				.stream()
				.filter(number -> collection.contains(number))
				.collect(Collectors.toList());

		return Collections.unmodifiableList(matched);
	}

	@Override
	public String toString() {
		return numbers.stream()
				.map(NumberElement::toString)
				.collect(Collectors.joining(TO_STRING_DELIMITER));
	}

	public static LottoNumberSet of(int[] numbers) {
		List<LottoNumber> elements = Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
		return new LottoNumberSet(elements);
	}

	public static LottoNumberSet of(String[] tokens) {
		List<LottoNumber> elements = Arrays.stream(tokens).map(LottoNumber::new).collect(Collectors.toList());
		return new LottoNumberSet(elements);
	}

}
