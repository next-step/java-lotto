package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoFactory makeLotto;
    private Lotto lotto;
    Lotto winningLotto;
    List<LottoNumber> lottoNumber;

    @BeforeEach
    void setUp() {
        makeLotto = new LottoFactory();
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        winningLotto= makeLotto.makeLottoWithString("1,2,3,8,9,10");

        lottoNumber = new ArrayList<>();
        lottoNumber.add(new LottoNumber(1));
        lottoNumber.add(new LottoNumber(2));
        lottoNumber.add(new LottoNumber(3));
        lottoNumber.add(new LottoNumber(4));
        lottoNumber.add(new LottoNumber(5));
        lottoNumber.add(new LottoNumber(6));
    }

    @Test
    @DisplayName("로또 객체 비교")
    public void compareLotto() {
        assertThat(new Lotto(lottoNumber)).isEqualTo(lotto);
    }

    @DisplayName("로또 번호 리스트 비교")
    public void compareLottoNumber() {
        Lotto checkLotto = new Lotto(lottoNumber);
        assertThat(checkLotto.getLottoNumber()).isEqualTo(lotto.getLottoNumber());
    }
}
