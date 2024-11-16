import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchCountTest {
    @Test
    void create(){
        assertThat(new MatchCount()).isEqualTo(new MatchCount(0));
    }

    @Test
    void increment(){
        MatchCount matchCount = new MatchCount(0);
        matchCount.tryIncrement(true);

        assertThat(matchCount).isEqualTo(new MatchCount(1));
    }
}
