package lotto;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void name() {
        Stream.of("1, 2, 3, 4, 5, 6".replace(" ","").split("\\D")).forEach(System.out::println);
    }
}
