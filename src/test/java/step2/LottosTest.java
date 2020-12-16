package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private LottoNumbers numbers1;
    private LottoNumbers numbers2;

    @BeforeEach
    public void setUp() {
        numbers1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        numbers2 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    @Test
    public void 일등_두번_테스트() {
        Lottos lottos = new Lottos(numbers1, numbers2);
        LottoNumbers answer =  new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        WinResults winResults = lottos.getWinResults(answer);
        assertThat(winResults).isEqualTo(new WinResults(
                Arrays.asList(WinResult.FIRST, WinResult.FIRST)
        ));
    }

    @Test
    public void 꼴찌_두번_테스트() {
        Lottos lottos = new Lottos(numbers1, numbers2);
        LottoNumbers answer =  new LottoNumbers(
                LottoNumber.of(11),
                LottoNumber.of(22),
                LottoNumber.of(33),
                LottoNumber.of(44),
                LottoNumber.of(15),
                LottoNumber.of(16)
        );
        WinResults winResults = lottos.getWinResults(answer);
        assertThat(winResults).isEqualTo(new WinResults(
                Arrays.asList(WinResult.MISS, WinResult.MISS)
        ));
    }

}
