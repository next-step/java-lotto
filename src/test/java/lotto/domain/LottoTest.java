package lotto.domain;

import lotto.domain.generator.TestLottoGenerator;
import lotto.domain.number.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    private TestLottoGenerator testLottoGenerator;

    @BeforeEach
    public void beforeEach() {
        testLottoGenerator = new TestLottoGenerator();
    }

    @Test
    @DisplayName("로또 생성 테스트")
    public void lottoGeneratorTest() {
        Lotto lotto = new Lotto(testLottoGenerator);
        HashSet<LottoNumber> set = new HashSet<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(41), new LottoNumber(42), new LottoNumber(43)));
        assertThat(lotto.equals(set)).isTrue();
    }

    @Test
    @DisplayName("로또 생성 테스트")
    public void lottoGeneratorTest2() {
        Lotto lotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        HashSet<LottoNumber> set = new HashSet<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(lotto.equals(set)).isTrue();
    }

    @Test
    @DisplayName("맞는 숫자가 몇개있는지 판별하는 메소드 테스트")
    public void checkTest() {
        Lotto lotto = new Lotto(testLottoGenerator);
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThat(lotto.findMatchCount(winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("lotto객체의 사이즈 확인")
    public void lottoSizeCheck() {
        assertThatIllegalStateException().isThrownBy(() ->
                new Lotto(new String[]{"1", "2", "3", "41", "42"})
        );
    }

    @Test
    void contains() {
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoNumber lottoNumber1 = new LottoNumber(6);
        LottoNumber lottoNumber2 = new LottoNumber(7);

        Assertions.assertThat(winningLotto.contains(lottoNumber1)).isTrue();
        Assertions.assertThat(winningLotto.contains(lottoNumber2)).isFalse();
    }
}