package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottiesTest {

    @DisplayName("여러개의 로또 뭉치 생성 테스트")
    @Test
    void createLotties() {
        Lotties lotties = new Lotties(Arrays.asList(Lotto.from("1, 2, 3, 4, 5, 6")));

        assertThat(lotties).isNotNull();
    }
}
