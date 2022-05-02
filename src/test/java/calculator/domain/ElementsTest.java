package calculator.domain;

import java.util.LinkedList;
import java.util.Queue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.Test;

public class ElementsTest {
    @Test
    void 생성_테스트() {
        Queue<Element> elementList = new LinkedList<>();
        elementList.add(new NumberElement("1"));
        elementList.add(new Plus());
        elementList.add(new NumberElement("2"));

        assertThat(Elements.of("1 + 2")).isEqualTo(new Elements(elementList));
    }

    @Test
    void poll_테스트() {
        Elements e = Elements.of("1 + 2");

        assertThat(e.poll()).isEqualTo(new NumberElement(1));
        assertThat(e.poll()).isEqualTo(new Plus());
        assertThat(e.poll()).isEqualTo(new NumberElement(2));
    }

    @Test
    void hasNextElements_테스트() {
        Elements e = Elements.of("1");

        assertThat(e.hasNextElements()).isTrue();
        e.poll();
        assertThat(e.hasNextElements()).isFalse();
    }

    @Test
    void 빈_수식_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Elements.of("");
                }).withMessageMatching("빈 수식은 입력이 불가능합니다");
    }
}
