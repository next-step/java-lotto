package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.ValidEmptyException;
import step2.exception.ValidNullException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoMatcherTest {

    @Test
    @DisplayName("지난주 당첨번호를 입력합니다.")
    void create() {
        LottoMatcher lottoMatcher = new LottoMatcher("1 ,2 ,3 ,4 ,5 , 6");
        assertThat(lottoMatcher.getLottoNumbers()).hasSize(6);
        assertThat(lottoMatcher.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("널값을 넣었을때 익셉션 발생")
    @Test
    void validNull() {
        assertThatThrownBy(() -> new LottoMatcher(null))
                .isInstanceOf(ValidNullException.class);
    }


    @DisplayName("빈 문자열을 넣었을때 익셉션 발생")
    @Test
    void validEmpty() {
        assertThatThrownBy(() -> new LottoMatcher(" "))
                .isInstanceOf(ValidEmptyException.class);
    }

}
