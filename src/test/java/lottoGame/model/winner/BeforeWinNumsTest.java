package lottoGame.model.winner;

import static lottoGame.fixture.LottoFixture.당첨번호리스트를_오름차순으로_생성한다;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BeforeWinNumsTest {

    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void 특정번호가_당첨번호에_포함되어있는지_확인할_수_있다(int num, boolean expect) {
        BeforeWinNums beforeWinNums = 당첨번호리스트를_오름차순으로_생성한다(6);
        assertThat(
                beforeWinNums.isContain(num)
        ).isEqualTo(expect);
    }
}