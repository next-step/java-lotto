package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    public void 로또_number_범위가_넘어갔을경우_에러(){
        assertThatThrownBy(() ->new LottoNumber(100))
            .hasMessageContaining("Lotto number의 범위를 넘어섰습니다.");
    }
}
