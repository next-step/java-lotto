package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void stringFormatMemoryTest() {
        String a = String.format("a %d", 1);
        String b = String.format("a %d", 1);

        assertThat(System.identityHashCode(a) == System.identityHashCode(b)).isFalse();
    }

    @Test
    void stringMemoryTest_1() {
        String a = "a " + 1;
        String b = "a " + 1;

        assertThat(System.identityHashCode(a) == System.identityHashCode(b)).isTrue();
    }

    @Test
    void stringMemoryTest_2() {
        String a = "a " + 1;

        assertThat(System.identityHashCode("a " + 1) == System.identityHashCode(a)).isTrue();
    }

    @Test
    void stringMemoryTest_3() {
        String a = new String("a " + 1);
        String b = new String("a " + 1);

        assertThat(System.identityHashCode(a) == System.identityHashCode(b)).isFalse();
    }
}
