package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoNumber;

public class AutomaticLottoGeneratorTest {

	@ParameterizedTest
	@MethodSource("parametersProvider")
	@DisplayName("랜덤 숫자 반환 테스트")
	void test랜덤테스트(List<LottoNumber> input, LottoNumber number) {

		AutomaticLottoGenerator autoLottoGenerator = new AutomaticLottoGenerator() {
			@Override
			protected Lotto getLotto() {
				return new Lotto(input);
			}
		};

		assertThat(autoLottoGenerator.getLotto().contains(number)).isTrue();
	}

	static Stream<Arguments> parametersProvider() {
		LottoNumber lottoNumber = LottoNumber.of(1);
		LottoNumber lottoNumber1 = LottoNumber.of(3);
		LottoNumber lottoNumber2 = LottoNumber.of(5);
		LottoNumber lottoNumber3 = LottoNumber.of(7);
		LottoNumber lottoNumber4 = LottoNumber.of(9);
		LottoNumber lottoNumber5 = LottoNumber.of(11);
		List<LottoNumber> lottoNumbers = Arrays.asList(lottoNumber, lottoNumber1, lottoNumber2, lottoNumber3,
			lottoNumber4, lottoNumber5);

		return Stream.of(arguments(lottoNumbers, lottoNumber), arguments(lottoNumbers, lottoNumber1),
			arguments(lottoNumbers, lottoNumber2), arguments(lottoNumbers, lottoNumber3),
			arguments(lottoNumbers, lottoNumber4), arguments(lottoNumbers, lottoNumber5));
	}

}
