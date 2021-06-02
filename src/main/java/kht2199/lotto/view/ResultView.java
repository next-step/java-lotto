package kht2199.lotto.view;

import static java.lang.System.*;

import java.util.Map;

import kht2199.lotto.entity.Rank;
import kht2199.lotto.entity.LottoAssets;
import kht2199.lotto.entity.LottoWinningResult;
import kht2199.lotto.entity.LottoList;
import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.LottoGameStateException;
import kht2199.lotto.exception.LottoListEmptyException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

/**
 *
 * @author heetaek.kim
 */
public class ResultView {

	public void printLottoList(LottoList lottoList) {
		int auto = lottoList.countAuto();
		int size = lottoList.size();
		print(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", size - auto, auto));
		print(lottoList.toString());
	}

	public void printResultStatistics(LottoWinningResult result, LottoAssets assets) {
		print("당첨 통계");
		print("---------");
		// 어떻게 print 할 것인지 ResultView 에서 결정하기 위해, toString 미구현.
		Map<Rank, Integer> matchedPrizeMap = result.rankPrizeMap();
		for (Rank value : Rank.range(3, 6, false)) {
			printResultOfMatched(value, matchedPrizeMap.get(value));
		}
		int totalPrize = result.getTotalPrize();
		int assetsUsed = assets.getAssetsUsed();
		print(String.format("총 수익률은 %.2f입니다.", rate(totalPrize, assetsUsed)));
	}

	/**
	 * 5등의 경우, 보너스 볼 일치여부까지 출력한다.
	 */
	private void printResultOfMatched(Rank rank, int prize) {
		String format = "%d개 일치 (%d원)- %d개";
		int countOfMatched = rank.getWinningMoney() == 0 ? 0 : prize / rank.getWinningMoney();
		if (rank == Rank.SECOND) {
			format = "5개 일치, 보너스 볼 일치(%d) - %d개";
			print(String.format(format, Rank.SECOND.getWinningMoney(), countOfMatched));
			return;
		}
		print(String.format(format, rank.getCountOfMatch(), rank.getWinningMoney(), countOfMatched));
	}

	public void printException(DomainException e) {
		if (e instanceof InvalidInputException) {
			print(inputErrorToMessage((InvalidInputException) e));
		}

		if (e instanceof LottoBonusNumberDuplicatedException) {
			print("로또 번호가 중복입니다.");
		}

		if (e instanceof LottoListEmptyException) {
			print("구매가능한 로또가 없습니다.");
		}
		if (e instanceof LottoGameStateException) {
			print("게임상태가 유효하지 않습니다. " + e.getMessage());
		}
		if (e instanceof LottoNumberRangeException) {
			print("로또 번호가 유효하지 않습니다.");
		}
		if (e instanceof AssetsNotEnoughException) {
			print("금액이 부족합니다.");
			e.printStackTrace();
		}
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

	public void print(String message) {
		out.println(message);
	}

	/**
	 * 수익률을 계산한다.
	 *
	 * @param assets 사용한 자산.
	 * @return 수익률 범위 0~1
	 */
	public float rate(int totalPrize, int assets) {
		return (float) totalPrize / assets;
	}
}
