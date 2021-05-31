package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    public void Lotto_번호비교_검증() {
        LottoGame lottoGame = new LottoGame();

        int[] numbers = {1,2,3,4,5,43};
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        WiningLottoNumbers winingLottoNumbers = new WiningLottoNumbers("1,2,3,4,5,6","7");
    }
}