package lotto.domain.lottoTicketsStrategy;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.BuyInfo;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ManualNumbers;
import lotto.utils.SplitUtils;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class ManualLottoTicketsStrategy implements LottoTicketsStrategy {

	@Override
	public LottoTickets generate(BuyInfo buyInfo) {
		ManualNumbers manualNumbers = buyInfo.getManualNumbers();

		List<LottoTicket> collect = manualNumbers.getManualNumbers().stream()
			.map(manualNumber -> convertUserInput(manualNumber))
			.map(lottoNumbers -> new LottoTicket(lottoNumbers))
			.collect(Collectors.toList());

		return new LottoTickets(collect);
	}

	private List<LottoNumber> convertUserInput(String arg) {
		return SplitUtils.userInputNumbersToLottoNumbers(arg);
	}

}
