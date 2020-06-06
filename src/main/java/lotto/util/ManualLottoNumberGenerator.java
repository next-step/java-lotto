package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

	List<LottoNumber> allNumberList;

	public ManualLottoNumberGenerator() {
		this.allNumberList = LottoNumberGenerator.generateLottoNumbers();
	}

	public List<LottoNumber> pickList(List<Integer> pickedValues) {
		List<LottoNumber> pickedValuesToNumbers = create(pickedValues);
		LottoNumberGenerator.sortDescLottoNumbers(pickedValuesToNumbers);
		return Collections.unmodifiableList(pickedValuesToNumbers);
	}

	private List<LottoNumber> create(List<Integer> pickedValues) {
		return pickedValues.stream()
			.map(this::createEach)
			.collect(Collectors.toList());
	}

	private LottoNumber createEach(int pickedValue) {
		if (isMatchedValue(pickedValue)) {
			return new LottoNumber(pickedValue);
		}
		throw new RuntimeException("잘못된 번호를 입력하셨습니다.");
	}

	private boolean isMatchedValue(int pickedValue) {
		return allNumberList.stream()
			.anyMatch(number -> number.getNumber() == pickedValue);
	}
}
