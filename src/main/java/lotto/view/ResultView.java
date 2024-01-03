package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public final class ResultView {
	public static void printEntireLotto(final List<Lotto> entireLotto) {
		for (Lotto lotto : entireLotto) {
			System.out.print("[");
			System.out.print(String.join(", ", integers(lotto)));
			System.out.println("]");
		}
	}

	private static List<String> integers(Lotto lotto) {
		List<String> result = new ArrayList<>();

		for (LottoNumber lottoNumber : lotto.lotto()) {
			result.add(lottoNumber.toString());
		}

		return result;
	}
}
