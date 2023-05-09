package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumTest {


    @Test
    @DisplayName("로또 번호 리스트 생성")
    void lottoNums() {
        LottoNums lottoNums = new LottoNums.Builder()
                .lottoNum(new LottoNum(1))
                .lottoNum(new LottoNum(2))
                .lottoNum(new LottoNum(3))
                .lottoNum(new LottoNum(4))
                .lottoNum(new LottoNum(5))
                .lottoNum(new LottoNum(6))
                .build();

        assertThat(lottoNums).isEqualTo(new LottoNums.Builder()
                .lottoNum(new LottoNum(1))
                .lottoNum(new LottoNum(2))
                .lottoNum(new LottoNum(3))
                .lottoNum(new LottoNum(4))
                .lottoNum(new LottoNum(5))
                .lottoNum(new LottoNum(6))
                .build());
    }

    @Test
    @DisplayName("로또 넘버 객체 생성")
    void lottoNum() {
        assertThat(new LottoNum(2)).isEqualTo(new LottoNum(2));
    }

    @Test
    @DisplayName("로또 넘버 객체 예외처리")
    void lottoNum_underNumAndOverNumThrows() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNum(0))
                .withMessageMatching("로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNum(46))
                .withMessageMatching("로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");
    }
}
