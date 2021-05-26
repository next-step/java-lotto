package kht2199.lotto.view;

import static java.lang.System.*;

import kht2199.lotto.LottoList;
import kht2199.lotto.LottoResult;
import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.assets.AssetsException;

/**
 *
 * @author heetaek.kim
 */
public class ResultView {

	public void handleException(AssetsException e) {
		print(e.getMessage());
	}

	public void printPurchased(LottoList list) {
		assert false;
	}

	public void printLottoList(LottoList lottoList) {
		assert false;
	}

	private void print(String message) {
		out.println(message);
	}

	public void printResultStatistics(LottoResult lottoResult) {
		assert false;
	}

	public void printException(DomainException e) {
		// TODO print for domain exceptions.
	}
}
