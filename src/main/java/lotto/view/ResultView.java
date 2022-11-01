package lotto.view;

import static java.lang.System.*;

import java.text.MessageFormat;

import lotto.view.dto.LottoStringsDto;
import lotto.view.dto.PurchaseCountDto;

public class ResultView {
	private static final String PURCHASE_COUNT_FORMAT = "{0}개를 구매하였습니다.";
	private static final String LINE_BREAK = "\n";

	public void printPurchaseCount(PurchaseCountDto purchaseCountDto) {
		print(MessageFormat.format(PURCHASE_COUNT_FORMAT, purchaseCountDto.getPurChaseCount()));
		print(LINE_BREAK);
	}

	public void printLottosString(LottoStringsDto lottosStringDto) {
		for (int i = 0; i < lottosStringDto.getLottoStrings().size(); i++) {
			print(lottosStringDto.getLottoStrings().get(i));
			print(LINE_BREAK);
		}
	}

	private void print(String text) {
		out.print(text);
	}
}
