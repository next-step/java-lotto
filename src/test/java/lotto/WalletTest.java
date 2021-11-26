package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(int money, List<Lotto> lottos) {
        // given
        Wallet self = new Wallet(10000, Arrays.asList(new Lotto(4, 5, 6, 7, 8, 9), new Lotto(1, 2, 3, 4, 5, 6)));

        // when
        Wallet other = new Wallet(money, lottos);

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(10000, Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(4, 5, 6, 7, 8, 9)))
        );
    }
}
