package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoNumber;
import lotto.domain.Message;

public class OutputView {

	public static void printLottoLotteriesStatus(LottoLotteries lottoLotteries) {
		printLottoCount(lottoLotteries.getCount());
		printLottoLotteries(lottoLotteries.getLottoLotteries());
	}

	public static void printLottoCount(int count) {
		System.out.println(count + Message.PRINT_NUMBER_OF_LOTTO_PURCHASED);
	}

	public static void printLottoLotteries(List<LottoLottery> lottoLotteries) {
		for (LottoLottery lottoLottery : lottoLotteries) {
			printLottoLottery(lottoLottery);
		}
	}

	public static void printLottoLottery(LottoLottery lottoLottery) {
		System.out.print("[");
		System.out.print(joinLottoNumber(lottoLottery.getLottoNumbers()));
		System.out.println("]");
	}

	public static String joinLottoNumber(List<LottoNumber> lottoNumbers) {
		return lottoNumbers.stream()
			.map(LottoNumber::toString)
			.collect(Collectors.joining(","));
	}
}
