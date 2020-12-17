package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningLottoNumbers {

	private static final String SPLIT_REGEX = ",";

	private LottoTicket lottoTicket;

	public WinningLottoNumbers(String arg) {
		lottoTicket = convertUserInput(arg);
	}

	private LottoTicket convertUserInput(String arg) {
		validateUserInput(arg);
		String[] splits = arg.split(SPLIT_REGEX);
		List<LottoNumber> convertedLottoNumbers = Arrays.stream(splits)
			.map(str -> parser(str))
			.collect(Collectors.toList());
		return new LottoTicket(convertedLottoNumbers);
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
			throw new IllegalArgumentException("입력된 당첨번호가 올바르지 않습니다.");
		}
	}

	public LottoTicket getLottoTicket() {
		return lottoTicket;
	}
}
