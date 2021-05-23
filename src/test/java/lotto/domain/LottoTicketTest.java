package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

	@DisplayName("유효성 검증 테스트")
	@Test
	void invalid_length() {
		// given
		HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2)));

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
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));

		return lottoNumbers;
	}

}
