package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.mock.PurchaseServiceMock;

public class PurchaseServiceTest {

	PurchaseService purchaseService;

	@BeforeEach
	void setUp() {
		purchaseService = new PurchaseService();
	}

	@DisplayName("구입금액을 입력했을 때 1000으로 나누어 로또가 구입된다.")
	@CsvSource({"14000, 14", "12300, 12", "18800, 18", "12500, 12"})
	@ParameterizedTest
	void 로또가_예상개수만큼_발급된다(Integer payable, Integer expected) {
		assertThat(PurchaseService.purchaseAllAuto(new Money(payable)).numberOfLottoTickets())
			.isEqualTo(expected);
	}

	private static List<LottoNumber> createLottoNumberListForTest(String valueList) {
		return Arrays.stream(valueList.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private static Stream<Arguments> autoAndManualLottoNumber() {
		List<LottoNumber> lottoTicketNumberValue1 = createLottoNumberListForTest("8,21,23,41,42,43");
		List<LottoNumber> lottoTicketNumberValue2 = createLottoNumberListForTest("3,5,11,16,32,38");
		List<LottoNumber> lottoTicketNumberValue3 = createLottoNumberListForTest("7,11,16,35,36,44");

		List<LottoTicket> lottoTicketList = new ArrayList<>();

		LottoTicket lottoTicket1 = new LottoTicket(lottoTicketNumberValue1);
		LottoTicket lottoTicket2 = new LottoTicket(lottoTicketNumberValue2);
		LottoTicket lottoTicket3 = new LottoTicket(lottoTicketNumberValue3);

		lottoTicketList.add(lottoTicket1);
		lottoTicketList.add(lottoTicket2);
		lottoTicketList.add(lottoTicket3);

		LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

		return Stream.of(
			Arguments.of(14000, lottoTickets, 3, 11, 14)
		);
	}

	@DisplayName("수동으로 구매한 로또티켓의 리스트가 들어오면, 그 리스트의 개수를 제외한 만큼 자동으로 발급해준다.")
	@MethodSource("autoAndManualLottoNumber")
	@ParameterizedTest
	void 수동로또를_제외하고_자동로또가_추가로_발급된다(Integer payable, LottoTickets lottoTickets, Integer manualExpected,
		Integer autoExpected, Integer totalExpected) {
		int getAutoLottoNum = PurchaseServiceMock.countToAutoDrawnLotto(new Money(payable), lottoTickets);
		LottoTickets lottoTicketsAfterAuto = PurchaseServiceMock.purchaseAutoDrawnLotto(getAutoLottoNum, lottoTickets);

		assertThat(lottoTicketsAfterAuto.numberOfLottoTickets() - getAutoLottoNum).isEqualTo(manualExpected);
		assertThat(getAutoLottoNum).isEqualTo(autoExpected);
		assertThat(lottoTicketsAfterAuto.numberOfLottoTickets()).isEqualTo(totalExpected);
	}

	@DisplayName("사용자가 수동으로 로또를 구매하면 해당하는 로또번호를 반환한다.")
	@CsvSource({"8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44"})
	@ParameterizedTest
	void 수동입력한_로또티켓_하나가_반환된다(String lottoNumberValue) {
		List<Integer> winningNumberBeforeList = Arrays.stream(lottoNumberValue.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		assertThat(PurchaseService.drawUserPickedTicket(winningNumberBeforeList))
			.isInstanceOf(LottoTicket.class);
	}
}
