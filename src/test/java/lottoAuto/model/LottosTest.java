package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private WinningLotto winningLottoTest;

    @BeforeEach
    public void set(){
        Set<LottoNumber> winningNumbers = new HashSet<>();
        winningNumbers.add(new LottoNumber(1));
        winningNumbers.add(new LottoNumber(2));
        winningNumbers.add(new LottoNumber(3));
        winningNumbers.add(new LottoNumber(4));
        winningNumbers.add(new LottoNumber(5));
        winningNumbers.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(winningNumbers);
        winningLottoTest = new WinningLotto(winningLotto,7);
    }

    @DisplayName("Lottos객체는 Lotto 결과 상태를 가진 객체를 반환한다.")
    @Test
    public void matchWinningLottoTest(){
        LottoGenerator lottoGenerator = new LottoGenerator(3);
        Lottos lottos = new Lottos(lottoGenerator.getLottos());

        assertThat(lottos.matchWinningLotto(winningLottoTest)).isInstanceOf(LottoResults.class);
    }
}
