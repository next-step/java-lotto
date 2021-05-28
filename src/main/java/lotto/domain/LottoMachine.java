package lotto.domain;

import lotto.function.FillListWithRepeatOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.CollectionUtils.*;

public class LottoMachine {

	public static final int PRICE = 1000;
	private static final int FROM_INDEX = 0;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final List<LottoNumber> lottoNumberList = unmodifiableLottoNumberList();

	private static List<LottoNumber> unmodifiableLottoNumberList() {
		return IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
				.mapToObj(LottoNumber::of)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	}

	public UserLotto buy(LottoBuyingRequest lottoBuyingRequest) {
		return new UserLotto(Collections.unmodifiableList(generateLottoTickets(lottoBuyingRequest)));
	}

	private List<LottoTicket> generateLottoTickets(LottoBuyingRequest lottoBuyingRequest) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(generateManualLottoTickets(lottoBuyingRequest));
		lottoTicketList.addAll(generateAutoLottoIfRequestExist(lottoBuyingRequest.autoLottoCount()));

		return lottoTicketList;
	}

	private List<LottoTicket> generateManualLottoTickets(LottoBuyingRequest lottoBuyingRequest) {
		return manual(lottoBuyingRequest.manualLottoNumberStrings());
	}

	List<LottoTicket> manual(List<String> numberStrings) {
		return transform(numberStrings, new ArrayList<>(), LottoTicketConverter::convert);
	}

	private List<LottoTicket> generateAutoLottoIfRequestExist(int count) {
		return new ArrayList<>(generate(count));
	}

	List<LottoTicket> generate(int count) {
		if (count == 0) {
			return Collections.emptyList();
		}

		return new FillListWithRepeatOperation<LottoTicket>()
				.andThen(Collections::unmodifiableList)
				.apply(count, this::generate);
	}

	private LottoTicket generate() {
		ArrayList<LottoNumber> tempLottoNumberList = new ArrayList<>(lottoNumberList);
		Collections.shuffle(tempLottoNumberList);
		List<LottoNumber> shuffledList = tempLottoNumberList.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);

		return new LottoTicket(Collections.unmodifiableSet(new HashSet<>(shuffledList)));
	}
}
