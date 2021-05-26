package lotto;

import utils.DrawNumber;

public final class LottoGenerator {
	private final static int LOTTO_NUMBER_COUNT = 6;

	private final LottoNumbersFactory lottoNumbersFactory; // 로또 티켓 관리 클래스
	private final DrawNumber drawNumber; // 숫자 뽑기 클래스

	public LottoGenerator(final LottoNumbersFactory lottoNumbersFactory, final DrawNumber drawNumber) {
		this.lottoNumbersFactory = lottoNumbersFactory;
		this.drawNumber = drawNumber;
	}

	public void add(final LottoNumbers lottoNumbers){
		lottoNumbersFactory.add(lottoNumbers);
	}

	public void autoGenerate(final LottoCount lottoCount) {
		for (int i = 0; i < lottoCount.autoCount(); ++i) {
			LottoNumbers lottoNumbers = new LottoNumbers(drawNumber.draw(LOTTO_NUMBER_COUNT));
			lottoNumbersFactory.add(lottoNumbers);
		}
	}
	public LottoNumbersFactory lottoNumbersFactory(){
		return this.lottoNumbersFactory;
	}

	public int size(){
		return this.lottoNumbersFactory.lottoList().size();
	}

	public LottoResult summary(final WinningLottoNumbers winningLottoNumbers) {
		return lottoNumbersFactory.summary(winningLottoNumbers);
	}
}
