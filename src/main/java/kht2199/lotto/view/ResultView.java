package kht2199.lotto.view;

import static java.lang.System.*;

import java.util.List;

import kht2199.lotto.Lotto;
import kht2199.lotto.LottoList;
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

	public void printResultStatistics(LottoWinningResult lottoWinningResult) {
		assert false;
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
			return "입력값의 포멧이 유효하지 않습니다";
		}
		throw new RuntimeException(exception);
	}

	private void print(String message) {
		out.println(message);
	}

}
