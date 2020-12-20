package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class SplitUtils {

	private static final String STRING_LOTTO_NUMBER_SPLIT_REGEX = ",";

	public static List<LottoNumber> userInputNumbersToLottoNumbers(String arg) {
		String[] splits = arg.split(STRING_LOTTO_NUMBER_SPLIT_REGEX);
		return Arrays.stream(splits)
			.map(str -> parser(str))
			.collect(Collectors.toList());
	}

	private static LottoNumber parser(String str) {
		try {
			String trimmed = str.trim();
			int result = Integer.parseInt(trimmed);
			return new LottoNumber(result);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력된 번호가 올바르지 않습니다.");
		}
	}
}
