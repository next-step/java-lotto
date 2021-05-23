package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoGameTest {

	@DisplayName("로또 게임 생성 테스트")
	@Test
	void constructor() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		Set<LottoNumber> lottoNumbers = getLottoNumbers();
		lottoTicketList.add(new LottoTicket(lottoNumbers));

		// then
		LottoGame lottoGame = new LottoGame(lottoTicketList);

		// then
		assertThat(lottoGame).isNotNull();
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

	@DisplayName("유효성 체크 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void invalid(List<LottoTicket> lottoTicketList) {
		assertThatThrownBy(() -> new LottoGame(lottoTicketList)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 게임 개수 테스트")
	@Test
	void size() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));

		// when
		LottoGame lottoGame = new LottoGame(lottoTicketList);

		// then
		assertThat(lottoGame.count()).isEqualTo(2);
	}

	@DisplayName("로또 번호 목록를 문자열로 받아오는 테스트")
	@Test
	void lottoNumbers() {
		// given
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));
		lottoTicketList.add(new LottoTicket(getLottoNumbers()));

		// when
		LottoGame lottoGame = new LottoGame(lottoTicketList);

		// then
		assertThat(lottoGame.lottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]\r\n[1, 2, 3, 4, 5, 6]\r\n");
	}

}
