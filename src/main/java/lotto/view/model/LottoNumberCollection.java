package lotto.view.model;

import common.NumberElement;
import common.NumberElementCollection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberCollection extends NumberElementCollection {

	private static final CharSequence TO_STRING_DELIMITER = ", ";

	public LottoNumberCollection() {
		super(LottoRule.MAX_COUNT);
	}

	/**
	 * 대상 컬렉션과 일치하는 숫자만 포함하는 컬렉션 반환
	 * @param collection
	 * @return
	 */
	public NumberElementCollection matchNumbers(NumberElementCollection collection) {

		List<NumberElement> matched = this.elements
				.stream()
				.filter(number -> collection.contains(number))
				.collect(Collectors.toList());

		return NumberElementCollection.of(matched);
	}

	public void sort() {
		Collections.sort(elements);
	}

	@Override
	public String toString() {
		return elements.stream()
				.map(NumberElement::toString)
				.collect(Collectors.joining(TO_STRING_DELIMITER));
	}

}
