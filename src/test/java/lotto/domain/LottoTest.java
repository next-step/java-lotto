package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LottoTest {

    private Set<LottoNumber> lottoTicket;

    @BeforeEach
    public void setUp() {
        lottoTicket = new HashSet<>();
        lottoTicket.add(new LottoNumber(1));
        lottoTicket.add(new LottoNumber(2));
        lottoTicket.add(new LottoNumber(3));
        lottoTicket.add(new LottoNumber(4));
        lottoTicket.add(new LottoNumber(5));
        lottoTicket.add(new LottoNumber(6));
    }

    @DisplayName("로또 숫자가 중복이 되면 예외를 던진다.")
    @Test
    public void lotto_DuplicateNumber_ThrowException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

    // 강의 19분부터 다시 보기 (정적 팩토리 메서드로 생성자 역할?) // todo
    @DisplayName("정적 메서드를 통해 로또 객체를 만들 수 있다.")
    @Test
    public void lotto_StaticMethod_CreateLotto() {
        Lotto lotto = new Lotto(lottoTicket);
        Assertions.assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("당첨번호가 몇 개 있는지 알 수 있다.")
    @Test
    public void match_CountWinNumber_Same() {
        Lotto winLotto = new Lotto(lottoTicket);
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 10, 11));

        Assertions.assertThat(lotto.match(winLotto)).isEqualTo(4);
    }

    @DisplayName("로또번호 중에 특정 번호가 있는지 알 수 있다.")
    @Test
    public void haveNumber_isTrue_Correct() {
        Lotto lotto = new Lotto(lottoTicket);

        Assertions.assertThat(lotto.haveNumber(new LottoNumber(1))).isTrue();
    }

}
