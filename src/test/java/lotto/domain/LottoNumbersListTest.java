package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersListTest {

    @Test
    public void LottoNumberList_생성_테스트() {

        int[] numbers1 = {1,2,3,4,5,6};
        LottoNumbers lottoNumbers1 = LottoNumbers.generateManualOf(numbers1);
        int[] numbers2 = {1,12,13,24,35,36};
        LottoNumbers lottoNumbers2 = LottoNumbers.generateManualOf(numbers2);

        LottoNumbers[] lottoNumbersArray = new LottoNumbers[2];
        lottoNumbersArray[0] = lottoNumbers1;
        lottoNumbersArray[1] = lottoNumbers2;

        LottoNumbersList lottoNumbersList = new LottoNumbersList(lottoNumbersArray);
        assertThat(lottoNumbersList.count()).isEqualTo(2);
        assertThat(lottoNumbersList.lottoNumberList(0).contains(1)).isTrue();
    }

}