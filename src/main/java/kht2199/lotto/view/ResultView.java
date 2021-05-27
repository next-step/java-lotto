package kht2199.lotto.view;

import static java.lang.System.*;

import java.util.List;

import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.LottoRule;
import kht2199.lotto.LottoWinningResult;
import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;

/**
 *
 * @author heetaek.kim
 */
public class ResultView {

	public void handleException(AssetsException e) {
		print(e.getMessage());
	}

	public void printInsertAssets() {
		print("구입금액을 입력해 주세요.");
	}

	public void printPurchased(LottoList list) {
		print(list.size() + "개를 구매했습니다");
	}

	public void printLottoList(LottoList lottoList) {
		List<Lotto> list = lottoList.getList();
		for (Lotto lotto : list) {
			print(lotto.toString());
		}
	}

	public void printMessageForWinningNumbers() {
		print("지난 주 당첨 번호를 입력해 주세요.");
	}

	public void printResultStatistics(LottoRule rule, LottoWinningResult lottoWinningResult, int assetsUsed) {
		print("당첨 통계");
		print("---------");
		for (int i = 3; i <= 6; i++) {
			print(String.format("%d개 일치 (%d원)- %d개", i, rule.prize(i), lottoWinningResult.countMatched(i)));
		}
		print(String.format("총 수익률은 %1f입니다.", lottoWinningResult.rate(assetsUsed)));
	}

	public void printException(DomainException e) {
		if (e instanceof InvalidInputException) {
			print(inputErrorToMessage((InvalidInputException)e));
		}
		// TODO print for domain exceptions.
	}

	private String inputErrorToMessage(InvalidInputException exception) {
		InvalidInputError error = exception.getError();
		if (error == InvalidInputError.EMPTY) {
			return "입력값이 없습니다.";
		}
		if (error == InvalidInputError.LENGTH) {
			return "입력값의 길이가 유효하지 않습니다.";
		}
		if (error == InvalidInputError.PARSING) {
			return "입력값의 포멧이 유효하지 않습니다.";
		}
		if (error == InvalidInputError.RANGE) {
			return "입력값의 범위가 유효하지 않습니다.";
		}
		throw new RuntimeException(exception);
	}

	private void print(String message) {
		out.println(message);
	}

}
