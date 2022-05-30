package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
	public static final int LOTTO_SIZE = 6;
	public static final Amount LOTTO_PRICE = new Amount(1_000);
	public static final String SPLIT_DELIMITER = ",";
	private final Set<LottoNumber> lottoNumbers;

	private Lotto() {
		lottoNumbers = new LinkedHashSet<>(LottoRandomGenerator.generate(LOTTO_SIZE));
		validateNumberSize(lottoNumbers);
	}

	private Lotto(Set<LottoNumber> lottoNumbers) {
		validateNumberSize(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto createAuto() {
		return new Lotto();
	}

	public static Lotto createManual(Set<LottoNumber> lottoNumbers) {
		return new Lotto(lottoNumbers);
	}

	private void validateNumberSize(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(String.format("로또는 %d개 숫자로 생성되어야 합니다. (size=%d)", LOTTO_SIZE, lottoNumbers.size()));
		}
	}

	public int size() {
		return lottoNumbers.size();
	}

	public List<LottoNumber> values() {
		return new ArrayList<>(lottoNumbers);
	}

	public boolean contain(LottoNumber number) {
		return lottoNumbers.contains(number);
	}

}
