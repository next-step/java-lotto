package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketConverterTest {

	@Test
	void convert() {
		String numberString = "1,2,3,4,5,6";
		LottoTicket lottoTicket = LottoTicketConverter.convert(numberString);

		assertThat(lottoTicket).isEqualTo(new LottoTicket(getLottoNumbers()));
	}

	private Set<LottoNumber> getLottoNumbers() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(LottoNumber.of(1));
		lottoNumbers.add(LottoNumber.of(2));
		lottoNumbers.add(LottoNumber.of(3));
		lottoNumbers.add(LottoNumber.of(4));
		lottoNumbers.add(LottoNumber.of(5));
		lottoNumbers.add(LottoNumber.of(6));

		return lottoNumbers;
	}

	@DisplayName("유효하지 않은 문자열을 전달했을 때, 예외가 발생하는지 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"", " ", "1,2,3", "1,2,3,4,5,6,7", "1,2,3,4,5,5", "1.2.3.4.5.6"})
	void constructor_invalid_number_string(String input) {
		assertThatThrownBy(() -> LottoTicketConverter.convert(input)).isInstanceOf(IllegalArgumentException.class);
	}

}
