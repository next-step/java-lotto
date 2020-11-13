import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplittersTest {

    @Test
    void getRegex() {
        Splitters splitters = new Splitters();

        String regex = splitters.getRegex();

        assertThat(regex).isEqualTo(",|:");
    }
}
