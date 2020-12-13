package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static step2.domain.LottoNumberGeneratorTest.assertionLottoNumberTest;

class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(BigDecimal.valueOf(14000));
    }

    @Test
    @DisplayName("구입한 금액만큼 로또 개수를 반환해주는 기능 테스트")
    void count() {
        Assertions.assertEquals(lottoGame.getCount(), 14);
    }

    @Test
    @DisplayName("로또 1장을 구매하였을 때 로또 번호 조건에 맞는지 기능 테스트 (로또는 6개의 숫자 && 각 숫자는 0~45이다)")
    void buyLottoNumber() {
        assertionLottoNumberTest(lottoGame.buyLottoNumber());
    }

    @Test
    @DisplayName("로또 14장을 구매하였을 때 로또 번호 조건에 맞는지 기능 테스트 (총 로또는 14개이고, 각 로또는 6개의 숫자 && 각 숫자는 0~45이다)")
    void buyLottoNumbers() {
        List<LottoNumber> lottoNumbers = lottoGame.buyLottoNumbers().getLottoNumbers();

        Assertions.assertEquals(lottoNumbers.size(), 14);
        for (int i=0; i<lottoNumbers.size(); i++) {
            assertionLottoNumberTest(lottoNumbers.get(i));
        }
    }



}