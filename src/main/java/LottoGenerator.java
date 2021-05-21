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

	public int buy(final int price){
		int lottoNumber = price / LOTTO_PRICE;
		if (lottoNumber <= 0) {
			return 0;
		}

		for(int i = 0; i < lottoNumber; ++i){
			LottoNumbers lottoNumbers = new LottoNumbers(drawNumber.draw(LOTTO_NUMBER_COUNT));
			lottoNumbersFactory.add(lottoNumbers);
		}
		return lottoNumber;
	}

	public static boolean isValidLottoCount(List<Integer> numbers){
		if(numbers == null) return false;
		return numbers.size() == LOTTO_NUMBER_COUNT;
	}

	public LottoResult summary(final List<Integer> winnerNumbers){
		LottoNumbers winnerLottoNumbers = new LottoNumbers(winnerNumbers);
		return lottoNumbersFactory.summary(winnerLottoNumbers);
	}

	public void printLottoAll(){
		lottoNumbersFactory.printAll();
	}
}
