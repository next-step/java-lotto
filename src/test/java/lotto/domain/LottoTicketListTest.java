package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoHitInfo;
import lotto.ui.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTicketListTest {

    private LottoTicketList lottoTicketList;

    @BeforeEach
    public void setUp() {
        List<String> manualLottoNumbers = new ArrayList();
        manualLottoNumbers.add("1,3,5,37,11,43");
        manualLottoNumbers.add("3,5,37,11,32,8");
        manualLottoNumbers.add("7,11,16,35,36,44");
        lottoTicketList = LottoTicketList.createManualLottoTicketList(manualLottoNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,7,33"})
    void 지난주_당첨번호와_보너스_번호를_입력받는다(String numbers) {

        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numberArrays = numbers.split(",");

        //when
        for (String number : numberArrays) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        //then
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 7, 33);
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 당첨통계를_구한다() {
        // given
        String hitNumbers = "3,5,37,11,32,8";
        LottoNumber bonusNumber = new LottoNumber(12);

        LottoHitInfo hitInfo = new LottoHitInfo(hitNumbers, bonusNumber);
        LottoResult lottoResult = LottoResult.from(lottoTicketList, hitInfo);
        lottoResult.printWinningStatistics();

        //then
        assertThat(lottoResult.findHitCount(LottoRank.FOUR_HIT)).isEqualTo(1);
        assertThat(lottoResult.findHitCount(LottoRank.FIVE_HIT)).isEqualTo(0);
        assertThat(lottoResult.findHitCount(LottoRank.FIVE_HIT_WITH_BONUS)).isEqualTo(0);
        assertThat(lottoResult.findHitCount(LottoRank.SIX_HIT)).isEqualTo(1);
    }
}
