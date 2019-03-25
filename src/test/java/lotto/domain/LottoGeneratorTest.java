package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    public void 로또생성기() {
        List<Integer> ticket = LottoGenerator.createLottoNumbers();
        assertThat(ticket).hasSize(6);
    }
}