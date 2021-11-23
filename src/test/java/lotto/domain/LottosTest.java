package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("Lottos 생성자 테스트")
    public void constructor() {
        assertThat(new Lottoes(Arrays.asList(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())))))
                .isEqualTo(new Lottoes(Arrays.asList(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())))));
    }
}
