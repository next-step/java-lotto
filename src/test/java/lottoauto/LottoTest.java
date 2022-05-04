package lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_1장_만들기() {
        Lotto auto = Lotto.createAuto();
        System.out.println(auto);
        assertThat(auto).isNotNull();
    }
}