package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_생성() {
        Lotto lotto = Lotto.create();

        assertThat(lotto.stream().allMatch(number -> number > 0 && number < 46))
                .isTrue();
        assertThat(lotto.stream().collect(Collectors.toList()))
                .isSorted();
    }
}
