package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersWrapperTest {

    @Test
    @DisplayName("로또 번호 일치 개수 계산 기능 테스트")
    public void lotteMatchCountTest() {
        LottoNumbersWrapper testLottoNumbersWrapper = getTestLottoNumbersWrapper();

        List<Integer> customCollectNumberList = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            customCollectNumberList.add(index + 1);
            assertThat(testLottoNumbersWrapper.getMatchCount(new LottoNumbersWrapper(customCollectNumberList))).isEqualTo(index + 1);
        }
    }

    private LottoNumbersWrapper getTestLottoNumbersWrapper() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            lottoNumbers.add(index + 1);
        }
        return new LottoNumbersWrapper(lottoNumbers);
    }
}