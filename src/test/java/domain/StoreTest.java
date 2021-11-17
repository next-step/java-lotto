package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class StoreTest {

    @Test
    @DisplayName("로또 구매금액 생성")
    public void createLotteryPrice() {
        Store store = new Store(10000);
        assertThat(store.price()).isEqualTo(10000);
    }

    @Test
    @DisplayName("로또 최소 구매금액 확인")
    public void validPriceMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Store(100);

            fail("최소금액 에러가 발생해야 한다.");
        });
    }

    @Test
    @DisplayName("나머지 금액 제거")
    public void discard() {
        Store store = new Store(1300);
        assertThat(store.discard()).isEqualTo(1000);
    }

    @Test
    @DisplayName("나머지 금액 제거한 로또 개수 생성")
    public void lotteryCount() {
        Store store = new Store(1300);
        assertThat(store.lotteryCount()).isEqualTo(1);
    }

    @Test
    public void a(){
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != 6) {
            numbers.add(RandomNumber.random());
        }

    }

}
