package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {
	List<LottoNumber> lottoNumbers;

	@BeforeEach
	void setUp() {
		lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
	}

	@Test
	public void createLottoTest() {
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto).isNotNull();
	}

	@Test
	public void getLottoNumbersTest() {
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto).isNotNull();
		//assertThat(lotto.lottoNumbers().toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}

	@Test
	public void getLottoPriceTest() {
		assertThat(Lotto.LOTTO_PRICE).isEqualTo(1000);
	}

	@Test
	public void equalsLottoTest() {
		Lotto sourceLotto = new Lotto(lottoNumbers);
		Lotto winningLotto = new Lotto(lottoNumbers);
		assertThat(sourceLotto).isNotNull();
		assertThat(winningLotto).isNotNull();
		assertThat(sourceLotto.equals(winningLotto)).isEqualTo(true);
	}

	@Test
	public void notEqualsLottoTest() {
		Lotto sourceLotto = new Lotto(lottoNumbers);
		List<LottoNumber> anotherLottoNumbers = new ArrayList<>();
		anotherLottoNumbers.add(new LottoNumber(1));
		anotherLottoNumbers.add(new LottoNumber(2));
		anotherLottoNumbers.add(new LottoNumber(3));
		anotherLottoNumbers.add(new LottoNumber(4));
		anotherLottoNumbers.add(new LottoNumber(5));
		anotherLottoNumbers.add(new LottoNumber(7));
		Lotto winningLotto = new Lotto(anotherLottoNumbers);
		assertThat(sourceLotto).isNotNull();
		assertThat(winningLotto).isNotNull();
		assertThat(sourceLotto.equals(winningLotto)).isEqualTo(false);
	}

	@Test
	public void matchesCount() {
		Lotto sourceLotto = new Lotto(lottoNumbers);
		List<LottoNumber> anotherLottoNumbers = new ArrayList<>();
		anotherLottoNumbers.add(new LottoNumber(1));
		anotherLottoNumbers.add(new LottoNumber(2));
		anotherLottoNumbers.add(new LottoNumber(3));
		anotherLottoNumbers.add(new LottoNumber(4));
		anotherLottoNumbers.add(new LottoNumber(5));
		anotherLottoNumbers.add(new LottoNumber(7));
		Lotto winningLotto = new Lotto(anotherLottoNumbers);
		assertThat(winningLotto.matchesCount(sourceLotto)).isEqualTo(5);
	}

}
