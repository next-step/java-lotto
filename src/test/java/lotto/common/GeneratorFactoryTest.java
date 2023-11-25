package lotto.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("로또 팩토리 테스트")
public class GeneratorFactoryTest {

    @DisplayName("로또 생성 방식에 따라 수동 로또와 자동 로또를 생성한다.")
    @Test
    void generateByMode() {
        Assertions.assertThat(GeneratorFactory.generate(List.of("1,2,3,4,5,6"))).isInstanceOf(List.class);
        Assertions.assertThat(GeneratorFactory.generate(5)).isInstanceOf(List.class);
    }
}
