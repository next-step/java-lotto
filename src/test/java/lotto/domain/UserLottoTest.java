package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class UserLottoTest {

	@DisplayName("로또 게임 생성 테스트")
	@Test
	void constructor() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		Set<LottoNumber> lottoNumbers = getLottoNumbers();
		lottoTicketList.add(new LottoTicket(lottoNumbers));

		// then
		UserLotto userLotto = new UserLotto(lottoTicketList);

		// then
		assertThat(userLotto).isNotNull();
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

	@DisplayName("유효성 체크 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void invalid(List<LottoTicket> lottoTicketList) {
		assertThatThrownBy(() -> new UserLotto(lottoTicketList)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 게임 개수 테스트")
	@Test
	void size() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));

		// when
		UserLotto userLotto = new UserLotto(lottoTicketList);

		// then
		assertThat(userLotto.count()).isEqualTo(2);
	}

	@DisplayName("로또 티켓 리스트를 반환하는 테스트")
	@Test
	void lottoTickets() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(LottoTicketConverter.convert("1,2,3,4,5,6"));
		UserLotto userLotto = new UserLotto(lottoTicketList);

		// when
		List<LottoTicket> actual = userLotto.lottoTickets();

		// then
		assertThat(actual).isEqualTo(lottoTicketList);
	}

	@Test
	void report() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(LottoTicketConverter.convert("1,2,3,4,5,6"));
		UserLotto userLotto = new UserLotto(lottoTicketList);

		// when
		LottoReport report = userLotto.report(new WinningLotto(LottoTicketConverter.convert("1,2,3,4,5,6"), LottoNumber.of(7)));

		// then
		assertThat(report).isNotNull();
	}

	@Test
	void given_null_to_constructor() {
		// given
		List<LottoTicket> lottoTickets = null;

		// when
		Throwable throwable = catchThrowable(() -> new UserLotto(lottoTickets));

		// then
		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void given_empty_list_to_constructor() {
		// given
		List<LottoTicket> lottoTickets = Collections.emptyList();

		// when
		Throwable throwable = catchThrowable(() -> new UserLotto(lottoTickets));

		// then
		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}
}
