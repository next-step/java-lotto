package lotto;

import exception.LottoException;
import utils.DrawNumber;
import utils.NumberUtils;
import utils.SeparatedText;
import utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static type.LottoExceptionType.NULL_PARAMETER;

public final class LottoGenerator {

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;

	private final LottoNumbersFactory lottoNumbersFactory; // 로또 티켓 관리 클래스
	private final DrawNumber drawNumber; // 숫자 뽑기 클래스

	public LottoGenerator(final LottoNumbersFactory lottoNumbersFactory) {
		checkNull(lottoNumbersFactory);
		this.lottoNumbersFactory = lottoNumbersFactory;
		this.drawNumber = DrawNumber.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
	}

	private void checkNull(final LottoNumbersFactory lottoNumbersFactory) {
		if (Objects.isNull(lottoNumbersFactory)) {
			throw LottoException.of(NULL_PARAMETER);
		}
	}

	public void generateManualLotto(final List<String> lottoNumbers) {
		Optional.ofNullable(lottoNumbers)
				.orElse(Collections.emptyList())
				.stream()
				.map(LottoGenerator::makeLottoNumbers)
				.forEach(this::add);
	}

	private void add(final LottoNumbers lottoNumbers) {
		lottoNumbersFactory.add(lottoNumbers);
	}

	public void generateAutoLotto(final LottoCount lottoCount) {
		for (int i = 0; i < lottoCount.autoCount(); ++i) {
			LottoNumbers lottoNumbers = new LottoNumbers(drawNumber.draw(LOTTO_NUMBER_COUNT));
			lottoNumbersFactory.add(lottoNumbers);
		}
	}

	public static LottoNumbers makeLottoNumbers(final String text) {
		SeparatedText separatedText = SeparatedText.findSeparator(text);
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		return new LottoNumbers(NumberUtils.parseInts(texts, lottoNumberCondition()));
	}

	private static Predicate<Integer> lottoNumberCondition() {
		return num -> {
			if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER) {
				return false;
			}
			return true;
		};
	}

	public LottoNumbersFactory lottoNumbersFactory() {
		return this.lottoNumbersFactory;
	}

	public int size() {
		return this.lottoNumbersFactory.lottoList().size();
	}

	public LottoResult summary(final WinningLottoNumbers winningLottoNumbers) {
		return lottoNumbersFactory.summary(winningLottoNumbers);
	}
}
