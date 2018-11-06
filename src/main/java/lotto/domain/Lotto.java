package lotto.domain;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 06/11/2018.
 */
public class Lotto {

	public static final int LOTTO_TICKET_AMOUNT = 1_000;
	private static Predicate<Integer> LOTTO_NUMBER_RANGE_PREDICATE = (i) -> i > 45 || i <= 0;
	private LottoMachine lottoMachine;
	private List<LottoTicket> lottoTicketList;

	public Lotto(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public List<LottoTicket> getLottoTicketList() {
		return Collections.unmodifiableList(lottoTicketList);
	}

	private void setLottoTicketList(List<LottoTicket> lottoTicketList) {
		this.lottoTicketList = lottoTicketList;
	}

	public List<LottoTicket> purchaseLottoTickets(int lottoPurchaseAmount) {
		Preconditions.checkArgument(lottoPurchaseAmount >= LOTTO_TICKET_AMOUNT, "로또 구매 금액 이하입니다.");
		Preconditions.checkArgument(lottoPurchaseAmount % LOTTO_TICKET_AMOUNT == 0, "1000원 단위로 입력해 주세요.");

		final int lottoTicketCount = lottoPurchaseAmount / LOTTO_TICKET_AMOUNT;
		List<LottoTicket> lottoTicketList = Stream.generate(() -> new LottoTicket(lottoMachine))
			.limit(lottoTicketCount).collect(Collectors.toList());
		setLottoTicketList(lottoTicketList);

		return getLottoTicketList();
	}

	public LottoMatchingResult matchNumber(List<Integer> previousWinningNumber) {
		Preconditions.checkArgument(previousWinningNumber.size() == 6, "로또 번호는 6자리여야합니다.");
		Preconditions.checkArgument(!previousWinningNumber.stream().filter(LOTTO_NUMBER_RANGE_PREDICATE).findAny().isPresent()
			, "잘못된 로또 번호입니다.");

		Map<LottoWinnerType, Long> lottoWinnerTypeListMap = lottoTicketList.stream().
			collect(Collectors.groupingBy(lottoTicket -> lottoTicket.matchNumber(previousWinningNumber), Collectors.counting()));

		return new LottoMatchingResult(lottoWinnerTypeListMap);
	}
}
