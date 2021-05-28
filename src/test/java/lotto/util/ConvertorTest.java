package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertorTest {
    @Test
    void 스트링_리스트_반환_테스트() {
        assertThat(Convertor.convertStringToList("1,2,3,4,5,6").contains(1)).isTrue();
        assertThat(Convertor.convertStringToList("1, 2, 3, 4, 5, 6").contains(1)).isTrue();
    }
}