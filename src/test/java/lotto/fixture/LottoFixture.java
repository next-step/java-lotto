package lotto.fixture;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class LottoFixture {
    public static Stream<Arguments> falseLottoFixture() {
        return Stream.of(
                Arguments.of(List.of(0, 6, 17, 28, 39, 45)),
                Arguments.of(List.of(6, 17, 28, 39, 45, 46))
        );
    }
}
