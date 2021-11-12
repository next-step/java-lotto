package lotto.generator;

import java.util.Arrays;
import java.util.List;

import lotto.domain.LottoNumber;

public class FixedGenerator implements Generator {
	public static final List<LottoNumber> FIXED_NUMBERS = Arrays.asList(
		LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4),
		LottoNumber.create(5), LottoNumber.create(6));

	@Override
	public List<LottoNumber> generate() {
		return FIXED_NUMBERS;
	}
}
