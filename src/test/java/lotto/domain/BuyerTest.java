package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    @DisplayName("구매자 생성 테스트")
    public void create() throws Exception {
        Name name = new Name("seongbeen");
        Buyer buyer = new Buyer(name);
        assertThat(buyer).isEqualTo(new Buyer(name));
    }
}
