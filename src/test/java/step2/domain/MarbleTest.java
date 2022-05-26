package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MarbleTest {

    @Test
    void create() {
        assertThat(new Marble(0)).isEqualTo(new Marble());
    }

}