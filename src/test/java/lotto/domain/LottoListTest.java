package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LottoListTest {

    private static final int AUTO_COUNT = 3;
    private static final int MANUAL_COUNT = 1;

    @Test
    @DisplayName("자동 로또 갯수만큼가 생성되는지 확인한다.")
    void createAutoLottoListTest() {

        //given
        LottoList lottoList = LottoList.of(AUTO_COUNT, 0);

        //then
        assertThat(lottoList.getLottoList()).hasSize(AUTO_COUNT);
    }

    @Test
    @DisplayName("수동 로또가 갯수만큼가 생성되는지 확인한다.")
    void createManualLottoListTest() {


        //given
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoList lottoList = LottoList.of(0, MANUAL_COUNT);


        //then
        assertThat(lottoList.getLottoList()).hasSize(MANUAL_COUNT);
    }
}