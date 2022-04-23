package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("랜덤 로또 생성기")
class RandomGeneratorTest {

    @Test
    @DisplayName("직접 객체화 불가능")
    void instance_thrownAssertionError() {
        assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> ReflectionUtils.newInstance(RandomGenerator.class));
    }

    @Test
    @DisplayName("랜덤 로또 생성")
    void lottoTicket() {
        assertThat(RandomGenerator.getInstance().lottoTicket()).isNotNull();
    }
}
