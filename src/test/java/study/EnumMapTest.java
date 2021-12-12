package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("EnumMap 학습 테스트")
class EnumMapTest {
    private EnumMap<TestEnum, Integer> enums;

    @BeforeEach
    void setUp() {
        enums = new EnumMap<>(TestEnum.class);
    }

    @DisplayName("EnumMap 생성")
    @Test
    void createEnumMapTest() {
        // then
        assertThat(enums).isNotNull();
    }

    @DisplayName("EnumMap 인자 넣기")
    @Test
    void putEnumMapTest() {
        // when
        enums.put(TestEnum.FIRST, 0);
        enums.put(TestEnum.SECOND, 0);
        // then
        assertThat(enums).containsKeys(TestEnum.values());
    }

    @DisplayName("EnumMap 인자 가져오기")
    @Test
    void getEnumMapTest() {
        // given
        int expected = 0;
        enums.put(TestEnum.FIRST, expected);
        // when
        int actual = enums.get(TestEnum.FIRST);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    private enum TestEnum {
        FIRST, SECOND
    }
}
