package lotto;

import utils.DrawNumber;

public final class LottoGenerator {
	private final static int LOTTO_NUMBER_COUNT = 6;

	private final LottoNumbersFactory lottoNumbersFactory; // 로또 티켓 관리 클래스
	private final DrawNumber drawNumber; // 숫자 뽑기 클래스

	public LottoGenerator(final LottoNumbersFactory lottoNumbersFactory, final DrawNumber drawNumber){
		this.lottoNumbersFactory = lottoNumbersFactory;
		this.drawNumber = drawNumber;
	}

	public LottoNumbersFactory buy(final LottoMoney lottoMoney){
		final int lottoCount = lottoMoney.calculateLottoCount();
		for (int i = 0; i < lottoCount; ++i){
			LottoNumbers lottoNumbers = new LottoNumbers(drawNumber.draw(LOTTO_NUMBER_COUNT));
			lottoNumbersFactory.add(lottoNumbers);
		}
		return this.lottoNumbersFactory;
	}

	public LottoResult summary(final LottoNumbers winnerNumbers){
		return lottoNumbersFactory.summary(winnerNumbers);
	}
}
