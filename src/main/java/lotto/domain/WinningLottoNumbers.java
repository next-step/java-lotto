package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningLottoNumbers {
	private static final String REGEX = ",";
	private static final int LOTTO_TICKET_WINNING_COUNT = 6;
	private LottoTicket lottoTicket;

	public WinningLottoNumbers(String arg) {
		lottoTicket = convertUserInput(arg);
	}

	private LottoTicket convertUserInput(String arg) {
		validateUserInput(arg);
		String[] splits = split(arg);
		List<LottoNumber> convertedLottoNumbers = Arrays.stream(splits)
			.map(str -> parser(str))
			.collect(Collectors.toList());
		validateConvertedLottoNumbers(convertedLottoNumbers);
		return new LottoTicket(convertedLottoNumbers);
	}

	private void validateConvertedLottoNumbers(List<LottoNumber> convertedLottoNumbers) {
		if (convertedLottoNumbers.size() != LOTTO_TICKET_WINNING_COUNT)
			throw new IllegalArgumentException("서로 다른 6개의 당첨 번호를 입력해 주세요.");
	}

	private void validateUserInput(String arg) {
		if (arg == null || arg.isEmpty())
			throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
	}

	private LottoNumber parser(String str) {
		try {
			String trimmed = str.trim();
			int result = Integer.parseInt(trimmed);
			return new LottoNumber(result);
		} catch (NumberFormatException e) {
			throw new RuntimeException("입력된 당첨번호가 올바르지 않습니다.");
		}
	}

	private String[] split(String arg) {
		return arg.split(REGEX);
	}

	public LottoTicket getLottoTicket() {
		return lottoTicket;
	}
}
