package step3.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.LottoException;
import step3.constants.PrizeGrade;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGameTest {

	private static final List<LottoNumber> LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
																	new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingConstruction")
	void testConstruct(List<LottoNumber> lottoNumbers, String[] input) {
		assertThat(new LottoGame(lottoNumbers)).isEqualTo(new LottoGame(input));
	}

	@DisplayName("객체 생성 실패 테스트(String[] 으로 받으니 계속 에러나서 List로 받음...)")
	@ParameterizedTest
	@MethodSource("provideTestingFailConstruction")
	void failTestConstruct(List<String> input) {
		assertThrows(LottoException.class, () -> new LottoGame(input.toArray(new String[]{})));
	}

	@DisplayName("contains 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingContains")
	void contains(List<LottoNumber> lottoNumbers, LottoNumber lottoNumber) {
		assertThat(new LottoGame(lottoNumbers).contains(lottoNumber)).isTrue();
	}

	@DisplayName("confirmPrize 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingConfirmPrize")
	void confirmPrize(List<LottoNumber> lottoNumbers, LottoGame prizeGame, LottoNumber bonusNumber, PrizeGrade expect) {
		assertThat(new LottoGame(lottoNumbers).confirmPrize(new PrizeInfo(prizeGame, bonusNumber))).isEqualTo(expect);
	}

	@DisplayName("toString 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingToString")
	void testToString(List<LottoNumber> lottoNumbers, String expect) {
		assertThat(new LottoGame(lottoNumbers).toString()).isEqualTo(expect);
	}

	static Stream<Arguments> provideTestingConstruction() {
		return Stream.of(
				Arguments.of(LOTTO_NUMBERS, new String[]{"1","2","3","4","5","6"})
		);
	}
	static Stream<Arguments> provideTestingFailConstruction() {
		return Stream.of(
				Arguments.of(List.of("-1","2","3","4","5","46")),
				Arguments.of(List.of("1","1","3","4","4","6")),
				Arguments.of(List.of("a","d","e","4","4","6"))
		);
	}

	static Stream<Arguments> provideTestingContains() {
		return Stream.of(
				Arguments.of(LOTTO_NUMBERS, new LottoNumber(5))
		);
	}

	static Stream<Arguments> provideTestingConfirmPrize() {

		List<LottoNumber> prize = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
											new LottoNumber(4), new LottoNumber(5), new LottoNumber(44));

		LottoNumber bonusNumber = new LottoNumber(6);

		return Stream.of(
				Arguments.of(LOTTO_NUMBERS, new LottoGame(prize), bonusNumber, PrizeGrade.SECOND)
		);
	}
	static Stream<Arguments> provideTestingToString() {
		return Stream.of(
				Arguments.of(LOTTO_NUMBERS, "[1, 2, 3, 4, 5, 6]")
		);
	}

}
