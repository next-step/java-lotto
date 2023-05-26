package step2.lotto;

import static step2.lotto.domain.LottoTicket.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step2.lotto.domain.LottoNumber;

public class LottoFixedNumberGenerator implements LottoNumberGenerator {

	private final List<LottoNumber> fixedNumbers;

	private LottoFixedNumberGenerator(List<LottoNumber> fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}

	public static LottoFixedNumberGenerator from(List<Integer> fixedNumbers) {
		List<LottoNumber> lottoNumbers = fixedNumbers.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toList());

		return new LottoFixedNumberGenerator(lottoNumbers);
	}

	public static LottoFixedNumberGenerator createSequential(int startIndex) {
		List<LottoNumber> numbers = IntStream.range(startIndex, startIndex + LOTTO_NUMBER_LENGTH)
			.mapToObj(i -> LottoNumber.from(i))
			.collect(Collectors.toList());

		return new LottoFixedNumberGenerator(numbers);
	}

	public LottoFixedNumberGenerator shuffle() {
		Collections.shuffle(fixedNumbers);

		return this;
	}

	@Override
	public List<LottoNumber> generate() {
		return fixedNumbers;
	}
}
