package lotto.domain.util;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class StringSplitter {

	public static List<LottoTicket> bulkConvertStrToLottoNumSet(List<String> strs) {
		List<LottoTicket> tickets = new LinkedList<>();
		for (String str : strs) {
			tickets.add(new LottoTicket(convertStrToLottoNumSet(str)));
		}
		return tickets;
	}

	public static Set<LottoNumber> convertStrToLottoNumSet(String str) {
		String[] StrNums = str.split(", ");
		Set<LottoNumber> IntNum = new LinkedHashSet<>();
		for (String num : StrNums) {
			IntNum.add(new LottoNumber(strToInt(num)));
		}
		return IntNum;
	}

	private static Integer strToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("해당 문자열을 숫자로 변환할 수 없습니다.");
		}
	}
}
