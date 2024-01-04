package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printNumberOfLotto(price);
	}
}
