package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto.LottoNum;
import step2.domain.Lotto.LottoNums;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumTest {

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

    @Test
    @DisplayName("로또 번호 비교")
    void lottoNums_lottoNumsCompareToLottoList() {
        LottoNums lottoNums = new LottoNums(new LottoNums.Builder()
                .lottoNum(new LottoNum(1))
                .lottoNum(new LottoNum(2))
                .lottoNum(new LottoNum(16))
                .lottoNum(new LottoNum(19))
                .lottoNum(new LottoNum(30))
                .lottoNum(new LottoNum(32)));

        List<LottoNum> lottoNumList = new ArrayList<>();
        lottoNumList.add(new LottoNum(1));
        lottoNumList.add(new LottoNum(2));
        lottoNumList.add(new LottoNum(16));
        lottoNumList.add(new LottoNum(19));
        lottoNumList.add(new LottoNum(30));
        lottoNumList.add(new LottoNum(32));

        assertThat(lottoNums.compareTo(lottoNumList)).isEqualTo(6);
    }

}
