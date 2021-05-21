package lotto;

import exception.LottoException;
import type.DecimalType;
import ui.InputView;
import ui.ResultView;
import utils.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;
import static type.MessageType.*;

public final class LottoManager {
	private static final double DEFAULT_REVENUE_VALUE = 0.0;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	private final LottoGenerator lottoGenerator;

	public LottoManager(){
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(),
											DrawNumber.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
	}


	public static void run(){
		try{
			startLotto();
		}catch(LottoException e){
			ResultView.printExceptionMessage(e);
		}
	}

	public static void startLotto(){
		LottoManager lottoManager = new LottoManager();
		int price = InputView.inputPrice();
		buyLotto(lottoManager, price);
		List<Integer> winningLottoNumber = winningLottoNumber(lottoManager);
		CalculateResult(lottoManager, winningLottoNumber, price);
	}

	private static void buyLotto(final LottoManager lottoManager, final int price){
		int lottoCount = lottoManager.lottoGenerator.buy(price);
		ResultView.printMessage(makeLottoSizeMessage(lottoCount));
		lottoManager.lottoGenerator.printLottoAll();
		ResultView.printLine();
	}

	private static List<Integer> winningLottoNumber(final LottoManager lottoManager){
		List<Integer> winningLottoNumber = inputWinningNumber(lottoManager);
		ResultView.printLine();
		ResultView.printMessage(OUTPUT_RESULT.message());
		return winningLottoNumber;
	}

	private static void CalculateResult(final LottoManager lottoManager, List<Integer> winningLottoNumber, final int price){
		LottoResult lottoResult = lottoManager.lottoGenerator.summary(winningLottoNumber);
		lottoResult.printResult();
		double revenue = calculateRevenue(lottoResult, price);
		ResultView.printMessageWithoutLine(makeLottoRevenueMessage(revenue));
		if(revenue <= 1.0){
			ResultView.printMessage(OUTPUT_FAILED_LOTTO_REVENUE.message());
		}
	}

	private static String makeLottoRevenueMessage(final double revenue){
		return String.format(OUTPUT_LOTTO_REVENUE.message(), revenue);
	}

	private static String makeLottoSizeMessage(final int size){
		return new StringBuilder()
			.append(size)
			.append(OUTPUT_LOTTO_COUNT.message())
			.toString();
	}

	private static List<Integer> inputWinningNumber(final LottoManager lottoManager){
		String inputText = InputView.inputWinningNumber();
		SeparatedText separatedText = SeparatedText.findSeparator(inputText);
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		if(StringUtils.isEmptyArray(texts)){
			return Collections.emptyList();
		}
		List<Integer> lottoNumbers = NumberUtils.parseInts(texts, LottoManager.lottoNumberCondition());
		if(LottoGenerator.isValidLottoCount(lottoNumbers) == false){
			throw LottoException.of(WRONG_LOTTO_NUMBER);
		}
		return lottoNumbers;
	}

	private static Predicate<Integer> lottoNumberCondition(){
		return num -> {
			if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER) {
				return false;
			}
			return true;
		};
	}

	public static double calculateRevenue(final SumResult lottoResult, final int price){
		if(lottoResult == null) return DEFAULT_REVENUE_VALUE;

		int revenue = lottoResult.sumRevenue();
		return NumberUtils.mathRound(revenue, price, DecimalType.PLACE_TWO);
	}
}
