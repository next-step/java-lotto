package lotto.utils;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class GenerateLottoMachineTest {

    @SuppressWarnings("CodeBlock2Expr")
    @Test
    public void 로또_번호_중복이_있는지_천만번_검사() {
        IntStream.range(0, 10000000)
                .parallel()
                .forEach(i -> {
                    assertThat(GenerateLotto.create().stream().distinct())
                            .as("로또 번호가 6개가 아니면 실패")
                            .hasSize(6);
                });
    }

}