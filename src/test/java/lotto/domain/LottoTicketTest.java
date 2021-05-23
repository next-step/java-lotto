package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

	@DisplayName("유효성 검증 테스트")
	@Test
	void invalid_length() {
		// given
		HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2)));

		// then
		assertThatThrownBy(() -> new LottoTicket(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호 목록 출력 테스트")
	@Test
	void to_string() {
		// given
		Set<LottoNumber> lottoNumbers = getLottoNumbers();

		// when
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

		// then
		assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

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
		assertThatThrownBy(() -> new LottoTicket(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,16:5", "1,2,3,4,15,16:4", "1,2,3,14,15,16:3", "1,2,13,14,15,16:2",
		"1,12,13,14,15,16:1", "11,12,13,14,15,16:0"}, delimiter = ':')
	void compare(String numberPattern, int expected) {
		// given
		LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(new LottoTicket(numberPattern));
		UserLotto userLotto = new UserLotto(lottoTicketList);
		List<LottoTicket> lottoTickets = userLotto.lottoTickets();

		// when
		int matchCount = 0;
		for (LottoTicket lottoTicket : lottoTickets) {
			matchCount = LottoTicket.compare(winningLottoTicket, lottoTicket);
		}

		// then
		assertThat(matchCount).isEqualTo(expected);
	}

}
