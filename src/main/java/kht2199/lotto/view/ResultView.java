package kht2199.lotto.view;

import static java.lang.System.*;

import java.util.List;
import java.util.Map;

import kht2199.Rank;
import kht2199.lotto.LottoWinningResult;
import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
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

	public void printAskWinningNumbers() {
		print("지난 주 당첨 번호를 입력해 주세요.");
	}

	public void printResultStatistics(LottoWinningResult result, int assetsUsed) {
		print("당첨 통계");
		print("---------");
		Map<Rank, Integer> matchedPrizeMap = result.getMatchedPrizeMap();
		matchedPrizeMap.forEach(this::printResultOfMatched);
		print(String.format("총 수익률은 %1f입니다.", result.rate(assetsUsed)));
	}

	/**
	 * 5등의 경우, 보너스 볼 일치여부까지 출력한다.
	 */
	protected void printResultOfMatched(Rank rank, int prize) {
		String format = "%d개 일치 (%d원)- %d개";
		int countOfMatched = rank.getWinningMoney() == 0 ? 0 : prize / rank.getWinningMoney();
		print(String.format(format, rank.getCountOfMatch(), rank.getWinningMoney(), countOfMatched));
		if (rank == Rank.SECOND) {
			format = "5개 일치, 보너스 볼 일치(%d) - %d개";
			print(String.format(format, Rank.SECOND.getWinningMoney(), countOfMatched));
		}
	}

	public void printException(DomainException e) {
		if (e instanceof InvalidInputException) {
			print(inputErrorToMessage((InvalidInputException)e));
		}

		if (e instanceof LottoBonusNumberDuplicatedException) {
			print("로또 번호가 중복입니다.");
		}
		// TODO print for domain exceptions.
	}

	public void printException(NumberFormatException e) {
		e.printStackTrace();
		print("입력값이 숫자형이 아닙니다.");
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

	public void printAskBonusNumber() {
		print("보너스 볼을 입력해 주세요.");
	}
}
