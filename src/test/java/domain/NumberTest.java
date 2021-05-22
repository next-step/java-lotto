package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class NumberTest {
	@Test
	public void 빈문자열_또는_null을_입력할_경우_0을_반환해야한다(){
		Number zeroForNull = new Number();

		assertThat(zeroForNull).isEqualTo(0);

		Number zeroForEmpty = new Number("");

		assertThat(zeroForEmpty).isEqualTo(0);
	}

	@Test
	public void 숫자하나를_문자열로_입력할_경우_해당숫자를_반환한다(){

	}

}