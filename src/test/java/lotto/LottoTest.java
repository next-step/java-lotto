package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또생성숫자범위() {
        List<Number> next = Lotto.purchase().numbers();
        assertAll(() -> {
            for (Number number : next) {
                assertThat(Number.MIN_NUMBER <= number.value()
                    && number.value() <= Number.MAX_NUMBER).isTrue();
            }
        });
    }

    @Test
    void 구매정렬() {
        List<Number> next = Lotto.purchase().numbers();
        Iterator<Number> iterator = next.iterator();
        assertAll(() -> {
                Number prev = null;
                while (iterator.hasNext()) {
                    Number current = iterator.next();
                    if (prev == null) {
                        prev = current;
                        continue;
                    }
                    assertThat(prev.value() < current.value()).isTrue();
                    prev = current;
                }
            }
        );
    }

    @Test
    void 랜덤생성정렬() {
        List<Number> number1 = new ArrayList<>() {{
            add(new Number(1));
            add(new Number(6));
            add(new Number(5));
            add(new Number(4));
            add(new Number(20));
            add(new Number(10));
        }};
        List<Number> next = Lotto.nextRandom(number1).numbers();
        Iterator<Number> iterator = next.iterator();
        assertAll(() -> {
                Number prev = null;
                while (iterator.hasNext()) {
                    Number current = iterator.next();
                    if (prev == null) {
                        prev = current;
                        continue;
                    }
                    assertThat(prev.value() < current.value()).isTrue();
                    prev = current;
                }
            }
        );
    }

    @Test
    void 구성숫자크기() {
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(
                    List.of(new Number(1), new Number(2), new Number(3), new Number(4),
                        new Number(5))))
                .withMessageMatching("로또는 6개의 중복되지않은 숫자로만 구성 가능합니다 : 5"),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(
                    List.of(new Number(1), new Number(2), new Number(3), new Number(4),
                        new Number(5), new Number(6), new Number(7))))
                .withMessageMatching("로또는 6개의 중복되지않은 숫자로만 구성 가능합니다 : 7")
        );
    }

    @Test
    void 중복제거() {
        List<Number> numbers1 = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 6).stream().map(Number::new)
            .collect(
                Collectors.toList());
        List<Number> numbers2 = List.of(1, 1, 2, 2, 2, 3, 4, 5, 5, 6).stream().map(Number::new)
            .collect(
                Collectors.toList());
        List<Number> numbers3 = List.of(1, 2, 3, 3, 3, 3, 4, 4, 5, 6).stream().map(Number::new)
            .collect(
                Collectors.toList());
        assertAll(
            () -> assertThat(new Lotto(numbers1)).isEqualTo(new Lotto(numbers2)),
            () -> assertThat(new Lotto(numbers2)).isEqualTo(new Lotto(numbers3))
        );
    }

    @Test
    void 랜덤생성() {
        List<Number> number1 = new ArrayList<>() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(4));
            add(new Number(5));
            add(new Number(6));
        }};
        List<Number> number2 = new ArrayList<>() {{
            add(new Number(11));
            add(new Number(12));
            add(new Number(13));
            add(new Number(14));
            add(new Number(15));
            add(new Number(16));
            add(new Number(17));
        }};
        assertAll(
            () -> assertThat(Lotto.nextRandom(number1).numbers()).isNotEqualTo(
                Lotto.nextRandom(number2).numbers()),
            () -> assertThat(Lotto.nextRandom(number1).numbers()).hasSize(6),
            () -> assertThat(Lotto.nextRandom(number2).numbers()).hasSize(6)
        );
    }

    @Test
    void 로또생성() {
        List<Number> numbers1 = List.of(1, 2, 3, 4, 5, 6).stream().map(Number::new)
            .collect(Collectors.toList());
        List<Number> numbers2 = List.of(1, 2, 3, 4, 5, 6).stream().map(Number::new)
            .collect(Collectors.toList());
        assertThat(new Lotto(numbers1)).isEqualTo(new Lotto(numbers2));
    }

}
