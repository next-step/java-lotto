package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoCalculate;

public class ResultView {

	private static final String COMMA = ",";

	public static void printPurchasedLotto(List<LottoNumbers> lottoNumbers) {
		for (LottoNumbers lottoNumber : lottoNumbers) {
			printLotto(lottoNumber);
		}
	}

	private static void printLotto(LottoNumbers lottoNumber) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(separateLottoNumberAsString(lottoNumber.lottoNumbers()));
		stringBuilder.append("]");

		System.out.println(stringBuilder);
	}

	private static String separateLottoNumberAsString(List<LottoNumber> lottoNumbers) {
		return lottoNumbers.stream()
			.map(value -> String.valueOf(value.value()))
			.collect(Collectors.joining(COMMA));
	}

	public static void printLottoResult(LottoCalculate result) {
		System.out.println("당첨통계");
		System.out.println("------");
		System.out.printf("3개 일치 (5000원)- %d개%n", result.getFifthPlace());
		System.out.printf("4개 일치 (50000원)- %d개%n", result.getFourthPlace());
		System.out.printf("5개 일치 (1500000원)- %d개%n", result.getThirdPlace());
		System.out.printf("6개 일치 (2000000000원)- %d개%n", result.getFirstPlace());
		System.out.printf("총 수익률은 %.2f입니다.", result.getYield());
	}

}