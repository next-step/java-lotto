package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.dto.LottoResult;

public class ResultView {

	private static final String COMMA = ",";

	public static void printPurchasedLotto(List<LottoNumbers> lottoNumbers) {
		lottoNumbers.forEach(ResultView::printLotto);
	}

	private static void printLotto(LottoNumbers lottoNumber) {
		String stringBuilder = "[" + separateLottoNumberAsString(lottoNumber.lottoNumbers()) + "]";
		System.out.println(stringBuilder);
	}

	private static String separateLottoNumberAsString(List<LottoNumber> lottoNumbers) {
		return lottoNumbers.stream()
			.map(value -> String.valueOf(value.value()))
			.collect(Collectors.joining(COMMA));
	}

	public static void printLottoResult(LottoResult lottoResult) {
		System.out.println("당첨통계");
		System.out.println("------");
		System.out.printf("3개 일치 (5000원)- %d개%n", lottoResult.getFifth());
		System.out.printf("4개 일치 (50000원)- %d개%n", lottoResult.getFourth());
		System.out.printf("5개 일치 (1500000원)- %d개%n", lottoResult.getThird());
		System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개%n", lottoResult.getSecond());
		System.out.printf("6개 일치 (2000000000원)- %d개%n", lottoResult.getFirst());
		System.out.printf("총 수익률은 %.2f입니다.", lottoResult.getYield());
	}

}