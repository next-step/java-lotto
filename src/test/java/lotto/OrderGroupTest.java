package lotto;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderGroupTest {

	@Test
	public void 주문그룹_생성_테스트(){
		int size = 3;

		final OrderGroup orderGroup = new OrderGroup(size);

		assertThat(orderGroup.lottos().size()).isEqualTo(size);

	}
}