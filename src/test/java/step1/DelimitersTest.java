package step1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {
    @Test
    void create() {
        List<Delimiter> delimiters = new ArrayList() {{
            add(new Delimiter(","));
            add(new Delimiter(":"));
        }};
        assertThat(new Delimiters(delimiters)).isEqualTo(new Delimiters(delimiters));
    }
}
