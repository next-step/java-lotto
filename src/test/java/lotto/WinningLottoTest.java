package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLottoTest {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private Lotto lotto;

    @BeforeEach
    void setUp(){
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        lotto = new Lotto(lottoNumbers);
    }

    @DisplayName("지난 주 당첨번호에 보너스 번호가 포함되지 않으면 정상적으로 객체 생성")
    @Test
    void createTest(){
        LottoNumber bonusBall = new LottoNumber(7);

        assertThatCode(() -> {
            new WinningLotto(lotto, bonusBall);
        }).doesNotThrowAnyException();
    }
}
