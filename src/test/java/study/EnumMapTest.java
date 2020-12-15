package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("EnumMap 사용법을 확인하기 위한 테스트")
class EnumMapTest {

    @DisplayName("EnumMap 생성")
    @Test
    void createEnumMapTest() {
        // When
        EnumMap<TestEnum, Integer> enumMap = new EnumMap<>(TestEnum.class);
        // Then
        assertThat(enumMap).isNotNull();
    }

    @DisplayName("EnumMap 인자 넣기")
    @Test
    void putEnumMapTest() {
        // Given
        EnumMap<TestEnum, Integer> actual = new EnumMap<>(TestEnum.class);
        TestEnum[] expected = TestEnum.values();
        // When
        actual.put(TestEnum.FIRST, 0);
        actual.put(TestEnum.SECOND, 0);
        // Then
        assertThat(actual).containsKeys(expected);
    }

    @DisplayName("EnumMap 인자 가져오기")
    @Test
    void getEnumMapTest() {
        // Given
        EnumMap<TestEnum, Integer> enumMap = new EnumMap<>(TestEnum.class);
        final int expected = 0;
        enumMap.put(TestEnum.FIRST, expected);
        // When
        int actual = enumMap.get(TestEnum.FIRST);
        // Then
        assertThat(actual).isEqualTo(expected);
    }

    private enum TestEnum {
        FIRST, SECOND
    }
}
