package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberFactoryTest {

    @Test
    @DisplayName("Factory 에서 가져온 LottoNumber은 매번 메모리 캐시에서 가져온 동일한 객체이다.")
    void get() {
        assertThat(LottoNumberFactory.get(1) == new LottoNumber(1)).isFalse();
        assertThat(LottoNumberFactory.get(1) == LottoNumberFactory.get(1)).isTrue();

    }

    @Test
    @DisplayName("Factory 에서 String 인자를 넣어 가져온 LottoNumber도 매번 동일한 객체이다.")
    void testGet() {
        assertThat(LottoNumberFactory.get("2") == new LottoNumber(2)).isFalse();
        assertThat(LottoNumberFactory.get("2") == LottoNumberFactory.get(2)).isTrue();
    }
}