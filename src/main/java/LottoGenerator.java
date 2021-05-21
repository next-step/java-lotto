import java.util.List;

public class LottoGenerator {
	private final static int LOTTO_NUMBER_COUNT = 6;
	private final static int LOTTO_PRICE = 1000;

	private final LottoNumbersFactory lottoNumbersFactory;
	private final DrawNumber drawNumber;

	public LottoGenerator(final LottoNumbersFactory lottoNumbersFactory, final DrawNumber drawNumber){
		this.lottoNumbersFactory = lottoNumbersFactory;
		this.drawNumber = drawNumber;
	}

	public void buy(final int price){
		int lottoNumber = price / LOTTO_PRICE;
		if (lottoNumber <= 0) {
			return;
		}

		for(int i = 0; i < lottoNumber; ++i){
			LottoNumbers lottoNumbers = new LottoNumbers(drawNumber.draw(LOTTO_NUMBER_COUNT));
			lottoNumbersFactory.add(lottoNumbers);
		}
	}

	public LottoResult summary(final List<Integer> winnerNumbers){
		LottoNumbers winnerLottoNumbers = new LottoNumbers(winnerNumbers);
		return lottoNumbersFactory.summary(winnerLottoNumbers);
	}

	int lottoSize(){
		return lottoNumbersFactory.size();
	}
}
