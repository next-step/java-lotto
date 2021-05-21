import utils.DecimalType;
import utils.NumberUtils;

public class LottoManager {
	private static final double DEFAULT_REVENUE_VALUE = 0.0;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	private final LottoGenerator lottoGenerator;

	public LottoManager(){
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(),
											DrawNumber.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
	}


	public double calculateRevenue(final SumResult lottoResult, final int price){
		if(lottoResult == null) return DEFAULT_REVENUE_VALUE;

		int revenue = lottoResult.sumRevenue();
		return NumberUtils.mathRound(revenue, price, DecimalType.PLACE_TWO);
	}
}
