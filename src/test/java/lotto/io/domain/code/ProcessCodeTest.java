package lotto.io.domain.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProcessCodeTest {

	@DisplayName("4-2-1-4-1.`is~()` : 등가성 비교")
	@Test
	@Order(1)
	void isEqualMethods() {
		//given

		//when

		//then
		//isRequestInput()
		assertThat(ProcessCode.REQUEST_INPUT.isRequestInput()).isEqualTo(true);
		assertThat(ProcessCode.SYSTEM_IN.isRequestInput()).isEqualTo(false);
		assertThat(ProcessCode.FINISH.isRequestInput()).isEqualTo(false);
		//isSystemIn()
		assertThat(ProcessCode.REQUEST_INPUT.isSystemIn()).isEqualTo(false);
		assertThat(ProcessCode.SYSTEM_IN.isSystemIn()).isEqualTo(true);
		assertThat(ProcessCode.FINISH.isSystemIn()).isEqualTo(false);
		//isFinish()
		assertThat(ProcessCode.REQUEST_INPUT.isFinish()).isEqualTo(false);
		assertThat(ProcessCode.SYSTEM_IN.isFinish()).isEqualTo(false);
		assertThat(ProcessCode.FINISH.isFinish()).isEqualTo(true);
	}
}
