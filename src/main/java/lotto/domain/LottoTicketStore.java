package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketStore {

	public static LottoTicket purchaseLottoTicket(LottoPrice lottoPrice, List<String> manualInputs) {
		if (lottoPrice.availablePurchaseManualAmount(manualInputs.size())) {
			throw new IllegalArgumentException("구매 가격을 초과하였습니다.");
		}
		return getManualLottoTicket(manualInputs)
			.combine(getAutoLottoTicket(lottoPrice.getAutoCount()));
	}

	private static LottoTicket getAutoLottoTicket(int autoCount) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		IntStream.range(0, autoCount).forEach(amount ->
			lottoNumbers.add(LottoNumberGenerator.auto()));
		return LottoTicket.ofNumbers(lottoNumbers);
	}

	private static LottoTicket getManualLottoTicket(List<String> inputs) {
		return LottoTicket.ofNumbers(inputs.stream()
			.map(LottoNumberGenerator::ofInput)
			.collect(Collectors.toList()));
	}
}
