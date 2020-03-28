package lotto.domain.item;

import lotto.domain.item.LottoTicket;
import lotto.domain.item.OrderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OrderItemTest {

    private LottoTicket lotto = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("주문 리스트에 item을 추가하고 list의 크기를 비교 한다")
    @Test
    public void addItem() throws Exception {
        //given
        OrderItem orderItem = new OrderItem();

        //when
        orderItem = orderItem.addItem(lotto);

        //then
        assertThat(orderItem.size()).isEqualTo(1);
    }
}




