package lotto.domain;

import lotto.domain.validator.LottoPurchaseAmountValidator;
import lotto.domain.validator.PreviousWinningNumberValidator;
import lotto.domain.validator.Validator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 06/11/2018.
 */
public class Lotto {
	private static final Validator<Integer> PURCHASE_AMOUNT_VALIDATOR;
	private static final Validator<List<Integer>> PREVIOUS_WINNING_NUMBER_VALIDATOR;

	private LottoMachine lottoMachine;
	private List<LottoTicket> lottoTicketList;

	static {
		PURCHASE_AMOUNT_VALIDATOR = new LottoPurchaseAmountValidator();
		PREVIOUS_WINNING_NUMBER_VALIDATOR = new PreviousWinningNumberValidator();
	}

	public Lotto(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public List<LottoTicket> purchaseLottoTickets(int lottoPurchaseAmount) {
		PURCHASE_AMOUNT_VALIDATOR.valid(lottoPurchaseAmount);

		final int lottoTicketCount = lottoPurchaseAmount / LottoConstants.LOTTO_TICKET_AMOUNT;

		List<LottoTicket> lottoTicketList = Stream.generate(() -> new LottoTicket(lottoMachine))
			.limit(lottoTicketCount).collect(Collectors.toList());

		setLottoTicketList(lottoTicketList);

		return getLottoTicketList();
	}

	public LottoMatchingResult matchNumber(List<Integer> previousWinningNumber) {
		PREVIOUS_WINNING_NUMBER_VALIDATOR.valid(previousWinningNumber);

		Map<LottoWinnerType, Long> lottoWinnerTypeCountMap = lottoTicketList.stream().
			collect(Collectors.groupingBy(lottoTicket -> lottoTicket.matchNumber(previousWinningNumber),
				Collectors.counting()));

		return new LottoMatchingResult(lottoWinnerTypeCountMap);
	}

	public List<LottoTicket> getLottoTicketList() {
		return Collections.unmodifiableList(lottoTicketList);
	}

	private void setLottoTicketList(List<LottoTicket> lottoTicketList) {
		this.lottoTicketList = lottoTicketList;
	}

}
