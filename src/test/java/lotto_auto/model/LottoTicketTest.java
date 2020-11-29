package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    public void createLottoNumberTest() {

        LottoTicket lottoTicket = new LottoTicket();
        LottoNumbers lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> export = lottoNumbers.export();
        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(export).isNotNull(),
                () -> assertThat(export.size()).isEqualTo(6)
        );
    }

    @DisplayName("로또 1등 추첨 테스트")
    @Test
    public void drawFirstRankTest() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        LottoTicket lottoTicket = new LottoTicket(list);


        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        LottoNumbers winningLottoNumber = new LottoNumbers(lottoNumbers);

        LottoNumber bonusLottoNumber = new LottoNumber(27);
        DrawResult draw = lottoTicket.draw(winningLottoNumber, bonusLottoNumber);
        DrawResult firstDrawResult = DrawResult.valueOfRank(1);

        assertThat(draw).isEqualTo(firstDrawResult);

    }

    @DisplayName("로또 2등 추첨 테스트")
    @Test
    public void drawSecondRankTest() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        LottoTicket lottoTicket = new LottoTicket(list);


        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(27));
        LottoNumbers winningLottoNumber = new LottoNumbers(lottoNumbers);

        LottoNumber bonusLottoNumber = new LottoNumber(5);
        DrawResult draw = lottoTicket.draw(winningLottoNumber, bonusLottoNumber);
        DrawResult secondDrawResult = DrawResult.valueOfRank(2);

        assertThat(draw).isEqualTo(secondDrawResult);

    }

    @DisplayName("로또 3등 추첨 테스트")
    @Test
    public void drawThirdRankTest() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        LottoTicket lottoTicket = new LottoTicket(list);


        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(27));
        LottoNumbers winningLottoNumber = new LottoNumbers(lottoNumbers);

        LottoNumber bonusLottoNumber = new LottoNumber(10);
        DrawResult draw = lottoTicket.draw(winningLottoNumber, bonusLottoNumber);
        DrawResult thirdDrawResult = DrawResult.valueOfRank(3);

        assertThat(draw).isEqualTo(thirdDrawResult);

    }

}
