package lotto.domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	public static final int SIZE = 6;
	public static final int PRICE = 1000;

	private final LottoNumbers lottoNumbers;
	private Score score;

	public Lotto() {
		this(0);
	}

	public Lotto(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != Lotto.SIZE) {
			throw new IllegalArgumentException(String.format("로또의 크기는 %d이고, 중복된 수가 있으면 안됩니다.", Lotto.SIZE));
		}
		this.lottoNumbers = new LottoNumbers(new ArrayList<>(lottoNumbers));
		this.score = new Score(0);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(int... lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(0);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(int score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = new Score(score);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(Score score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = score;
	}

	public Score calculateScore(Lotto winningLotto, LottoNumber bonusNumber) {
		int matchCount = this.lottoNumbers.matchCount(winningLotto.lottoNumbers);
		int bonusCount = this.bonusCount(bonusNumber);
		this.score = new Score(matchCount, bonusCount);
		return this.score;
	}

	private int bonusCount(LottoNumber bonusNumber) {
		int bonusCount = 0;
		if (this.lottoNumbers.contains(bonusNumber)) {
			bonusCount = 1;
		}
		return bonusCount;
	}

	public Rank rank() {
		return Rank.of(this.score.getScore(), this.score.isMatchBonus());
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(lottoNumbers, lotto.lottoNumbers) && Objects.equals(score, lotto.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers, score);
	}
}
