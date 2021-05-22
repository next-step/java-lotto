package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class NumberTest {
	@Test
	public void 빈문자열_또는_null을_입력할_경우_0을_반환해야한다(){
		Number zeroForNull = new Number();

		assertThat(0).isEqualTo(zeroForNull.number());

		Number zeroForEmpty = new Number("");

		assertThat(0).isEqualTo(zeroForEmpty.number());
	}

	@Test
	public void 숫자하나를_문자열로_입력할_경우_해당숫자를_반환한다(){

	}


	@Test
	public void 음수를_전달할경우_RuntimeException예외가_발생해야한다(){

	}
}