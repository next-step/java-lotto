package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoFactoryTest {

    private Lotto checkLotto;
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumberList = new ArrayList<LottoNumber>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));

        checkLotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("로또번호 비교")
    public void makeLottoWithStringTest() {
        lottoFactory = new LottoFactory();
        assertThat(lottoFactory.makeLottoWithString("1,2,3,4,5,6")).isEqualTo(checkLotto);
    }
}
