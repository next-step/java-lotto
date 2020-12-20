package lotto.domain.lottoTicketsStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ManualNumbers;
import lotto.domain.BuyInfo;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class ManualLottoTicketsStrategy implements LottoTicketsStrategy {

	private static final String SPLIT_REGEX = ",";

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
		String[] splits = arg.split(SPLIT_REGEX);
		return Arrays.stream(splits)
			.map(str -> parser(str))
			.collect(Collectors.toList());
	}

	private LottoNumber parser(String str) {
		try {
			String trimmed = str.trim();
			int result = Integer.parseInt(trimmed);
			return new LottoNumber(result);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력된 번호가 올바르지 않습니다.");
		}
	}
}
