package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapTest {

    @Test
    void creation() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");
    }

    @Test
    void copiedEnumMap() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");
        enumMap.put(DayOfWeek.TUESDAY, "Basketball");

        EnumMap<DayOfWeek, String> copiedEnumMap = new EnumMap<>(enumMap);
        assertThat(copiedEnumMap.size()).isEqualTo(2); // size == 키의 개수
        assertThat(copiedEnumMap.get(DayOfWeek.MONDAY)).isEqualTo("Soccer");
        assertThat(copiedEnumMap.get(DayOfWeek.TUESDAY)).isEqualTo("Basketball");
    }

    @Test
    void copiedMap() {
        Map<DayOfWeek, String> hashMap = new HashMap<>();
        hashMap.put(DayOfWeek.MONDAY, "Soccer");

        EnumMap<DayOfWeek, String> copiedEnumMap = new EnumMap<>(hashMap);
        assertThat(copiedEnumMap.size()).isEqualTo(1); // size == 키의 개수
        assertThat(copiedEnumMap.get(DayOfWeek.MONDAY)).isEqualTo("Soccer");
    }

    @DisplayName("Object 배열에서 키에 해당하는 값이 널이 아닌지 확인한다")
    @Test
    void containsKey() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");
        enumMap.put(DayOfWeek.TUESDAY, "Basketball");
        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");

        assertThat(enumMap.containsKey(DayOfWeek.MONDAY)).isTrue(); // enum의 orinal()로 키 값 치환
    }

    @DisplayName("Object 배열을 순차조회하며 일치하는 값이 있는지 확인한다")
    @Test
    void containsValue() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");
        enumMap.put(DayOfWeek.TUESDAY, "Basketball");
        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");

        assertThat(enumMap.containsValue("Hiking")).isTrue();
    }

    @DisplayName("null 값을 조회하면 내부 정적 필드 NULL 객체로 대체 되므로 동등성 비교 시 안정적이다")
    @Test
    void safetyNull() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);

        assertThat(enumMap.containsKey(DayOfWeek.SATURDAY)).isFalse();
        assertThat(enumMap.containsValue(null)).isFalse();

        enumMap.put(DayOfWeek.SATURDAY, null); // 내부에서 null을 masking한다 (= NULL 정적 객체로 대체)
        assertThat(enumMap.containsKey(DayOfWeek.SATURDAY)).isTrue();
        assertThat(enumMap.containsValue(null)).isTrue();
    }

    @Test
    void remove() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");

        assertThat(enumMap.remove(DayOfWeek.MONDAY)).isEqualTo("Soccer");
        assertThat(enumMap.remove(DayOfWeek.MONDAY)).isNull();
        assertThat(enumMap.containsKey(DayOfWeek.MONDAY)).isFalse();

        enumMap.put(DayOfWeek.MONDAY, "Soccer");
        assertThat(enumMap.remove(DayOfWeek.MONDAY, "Hiking")).isFalse();
        assertThat(enumMap.remove(DayOfWeek.MONDAY, "Soccer")).isTrue();
    }

    /**
     * 데이터 조회
     */
    @Test
    void values() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap(DayOfWeek.class);
        enumMap.put(DayOfWeek.THURSDAY, "Karate");
        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        enumMap.put(DayOfWeek.MONDAY, "Soccer");

        Collection<String> values = enumMap.values();
        assertThat(values)
                .containsExactly("Soccer", "Hiking", "Karate");
    }

    @Test
    void keySet() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap(DayOfWeek.class);
        enumMap.put(DayOfWeek.THURSDAY, "Karate");
        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        enumMap.put(DayOfWeek.MONDAY, "Soccer");

        Set<DayOfWeek> keys = enumMap.keySet();
        assertThat(keys)
                .containsExactly(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);
    }

    @DisplayName("entrySet()은 Enum 클래스에 선언된 순서대로 반환한다")
    @Test
    void entrySet() {
        EnumMap<DayOfWeek, String> enumMap = new EnumMap(DayOfWeek.class);
        enumMap.put(DayOfWeek.THURSDAY, "Karate");
        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        enumMap.put(DayOfWeek.MONDAY, "Soccer");

        Set<Map.Entry<DayOfWeek, String>> entries = enumMap.entrySet();
        assertThat(entries)
                .containsExactly(
                        new AbstractMap.SimpleEntry<>(DayOfWeek.MONDAY, "Soccer"),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.WEDNESDAY, "Hiking"),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.THURSDAY, "Karate")
                );
    }
}
