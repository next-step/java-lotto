package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoLineTest {

    @DisplayName("로또 한줄 생성 성공")
    @Test
    void create_lotto_line_success() {
        LottoLine lottoLine = LottoLine.create();

        System.out.println(lottoLine.getLine());
        assertThat(lottoLine).isNotNull();
        assertThat(lottoLine.getLottoNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호가 6개 이상일 경우 IllegalArgumentException 예외 발생")
    @Test
    void create_lotto_line_fail() {
        assertThatThrownBy(() -> new LottoLine(Set.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7)))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");


    }
}
