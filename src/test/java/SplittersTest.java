import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SplittersTest {

    @Test
    void getRegex() {
        Splitters splitters = new Splitters(Arrays.asList(",", ":"));

        String regex = splitters.getRegex();

        assertThat(regex).isEqualTo(",|:");
    }
}