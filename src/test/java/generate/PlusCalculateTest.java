package generate;

import domain.Number;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlusCalculateTest {

	@Test
	public void 빈문자열_또는_null을_입력할_경우_0을_반환해야한다(){
		PlusCalculate zeroForNull = new PlusCalculate();

		assertThat(zeroForNull.excute("")).isEqualTo(0);

		assertThat(zeroForNull.excute(null)).isEqualTo(0);
	}
	
	@Test
	public void 덧셈연산_GREEN(){
	  PlusCalculate plusCalculate = new PlusCalculate();

    assertThat(plusCalculate.excute("1, 2, 3")).isEqualTo(6);

		assertThat(plusCalculate.excute("5, 2, 3")).isEqualTo(10);

		assertThat(plusCalculate.excute("10: 2: 3")).isEqualTo(15);
		// 흠... 입력값 형식을 알고있어야 작성할 수 있는 테스트..... 안좋은것같다.
	}
}