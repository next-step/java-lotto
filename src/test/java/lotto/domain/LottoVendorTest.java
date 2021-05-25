package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendorTest {

	@DisplayName("로또 당첨 결과 생성 테스트")
	@Test
	void report() {
		// given
		LottoVendor lottoVendor = new LottoVendor("1,2,3,4,5,6", "7");
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));
		UserLotto userLotto = new UserLotto(lottoTicketList);

		// when
		LottoReport lottoReport = lottoVendor.report(userLotto.lottoTickets());

		// then
		assertThat(lottoReport).isNotNull();
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

	@Test
	void invalid_lotto_number() {
		assertThatThrownBy(() -> new LottoVendor("1,2,3,4,5,6", "6")).isInstanceOf(IllegalArgumentException.class);
	}
}
