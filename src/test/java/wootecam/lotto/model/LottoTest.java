package wootecam.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import wootecam.lotto.exception.LottoException;

public class LottoTest {

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6"})
	void test_지난주당첨번호테스트생성테스트(String input) {
		List<LottoNumber> inputList = getNumberList(input);
		Lotto lotto = new Lotto(inputList);

		assertThat(lotto.contains(LottoNumber.of(1))).isTrue();
		assertThat(lotto.contains(LottoNumber.of(2))).isTrue();
		assertThat(lotto.contains(LottoNumber.of(3))).isTrue();
		assertThat(lotto.contains(LottoNumber.of(4))).isTrue();
		assertThat(lotto.contains(LottoNumber.of(5))).isTrue();
		assertThat(lotto.contains(LottoNumber.of(6))).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4", "2,3,4"})
	void test_지난주당첨번호입력이잘못된경우(String input) {
		assertThatThrownBy(() -> {
			List<LottoNumber> numberList = this.getNumberList(input);
			new Lotto(numberList);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("로또 번호는 6개여야 합니다.");
	}

	private List<LottoNumber> getNumberList(String input) {
		return Arrays.stream(input.split(","))
			.map(LottoNumber::of)
			.collect(Collectors.toList());
	}

}
