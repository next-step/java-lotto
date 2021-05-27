package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
	@Test
	public void 로또번호생성테스트(){
		Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6};

		final Lotto lotto = new Lotto(numbers);

		assertThat(lotto.numbers()).isEqualTo(numbers);
	}
	
	@Test
	public void 로또번호_매칭테스트(){
	    
	}
}