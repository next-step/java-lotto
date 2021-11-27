package lotto.model;

import lotto.factory.LottoNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("수동 로또 발행")
    void manualTicket() {
        List<LottoNumber> lottoNumbers = LottoNumbersFactory.manualCreateNumberList("1, 2, 3, 4, 5, 6");
        //TODO 테스트 작성
    }
}