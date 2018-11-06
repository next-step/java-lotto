package lotto.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_1000원_이하로_구매() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("로또 구매 금액 이하입니다.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(400);
	}

	@Test
	public void test_1000단위가_아닐때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("1000원 단위로 입력해 주세요.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoTicket> lottoTicketList = lotto.purchaseLottoTickets(1500);
		assertThat(lottoTicketList).hasSize(1);
	}

	@Test
	public void test_16000원_구매() {
		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoTicket> lottoTicketList = lotto.purchaseLottoTickets(16000);
		assertThat(lottoTicketList).hasSize(16);
	}

	@Test
	public void test_이전_당첨번호가_6자리가_아닐때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("로또 번호는 6자리여야합니다.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		lotto.matchNumber(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호가_46_이상일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(46, 47, 48, 49, 50, 51);
		lotto.matchNumber(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호가_0_이하일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 4, 5);
		lotto.matchNumber(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호에_숫자_중복이_있을때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("중복은 허용되지 않습니다.");

		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 5, 5);
		lotto.matchNumber(previousLottoNumber);
	}
}