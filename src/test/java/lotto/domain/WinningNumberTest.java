package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberTest {

    private Lotto lotto;

    @BeforeEach
    public void setUp() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(5)        // todo) new LottoNumber() 로 테스트 데이터 만드는 것 수정하기
                                                        , new LottoNumber(10)
                                                        , new LottoNumber(15)
                                                        , new LottoNumber(20)
                                                        , new LottoNumber(25)
                                                        , new LottoNumber(30));
        lotto = new Lotto(lottoNumberList);
    }

    @DisplayName("번호 중에 당첨번호가 몇 개 있다는 것을 알 수 있다.")
    @Test
    public void distinguish_WinningNumber_ExtractNumber() {
        List<LottoNumber> winningNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
        Lotto winningLotto = new Lotto(winningNumbers);
        WinningNumber winningNumber = new WinningNumber(winningLotto);
        int matchingCount = winningNumber.distinguish(lotto);

        Assertions.assertThat(matchingCount).isEqualTo(1);
    }
}
