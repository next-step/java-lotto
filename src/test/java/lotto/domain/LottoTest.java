package lotto.domain;

import lotto.domain.generator.ManualLottoGenerator;
import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    private ManualLottoGenerator manualLottoGenerator;

    @BeforeEach
    public void beforeEach() {
        manualLottoGenerator = new ManualLottoGenerator();
    }

    @Test
    @DisplayName("로또 생성 테스트")
    public void lottoGeneratorTest() {
        Lotto lotto = new Lotto(manualLottoGenerator);
        HashSet<LottoNumber> set = new HashSet<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(41), new LottoNumber(42), new LottoNumber(43)));
        assertThat(lotto.equals(set)).isTrue();
    }

    @Test
    @DisplayName("맞는 숫자가 몇개있는지 판별하는 메소드 테스트")
    public void checkTest() {
        Lotto lotto = new Lotto(manualLottoGenerator);
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.findMatchCount(winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("lotto객체의 사이즈 확인")
    public void lottoSizeCheck() {
        assertThatIllegalStateException().isThrownBy(() ->
                new WinningLotto("1, 2, 3, 41, 42")
        );
    }
}