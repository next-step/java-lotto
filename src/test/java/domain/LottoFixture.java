package domain;

import generate.LottoRandomNumberGenerator;

import java.util.List;

public class LottoFixture {
	public static Lotto 로또_생성(List<Integer> numbers) {
		return new Lotto(
				new LottoRandomNumberGenerator() {
					@Override
					public List<Integer> randomNumber(Integer length) {
						return numbers;
					}
				}
		);
	}
}
