package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoHistory;
import step2.domain.LottoStast;

public class ResultView {

	public static void printLottoResult(LottoHistory result) {
		List<Lotto> lottoResult = result.getHistory();
		System.out.println(lottoResult.size() + " 개를 구매했습니다.");
		for (Lotto lotto : lottoResult) {
			System.out.println(lotto.toString());
		}
	}

	public static void printLottoStast(LottoStast stastResult) {
	}
}
