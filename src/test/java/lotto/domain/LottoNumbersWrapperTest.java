package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersWrapperTest {
    private static LottoNumbersWrapper testLottoNumbersWrapper;
    private static final int NOT_LOTTO_NUMBER = -1;

    @BeforeAll
    static void getTestLottoNumbersWrapper() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            lottoNumbers.add(index + 1);
        }
        testLottoNumbersWrapper = new LottoNumbersWrapper(lottoNumbers);
    }

    @Test
    @DisplayName("로또 번호 일치 개수 계산 기능 테스트")
    public void getMatchCountTest() {
        List<Integer> numbers = testLottoNumbersWrapper.getNumbers();
        List<Integer> customCollectNumberList = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            customCollectNumberList.add(numbers.get(index));
            assertThat(testLottoNumbersWrapper.getMatchCount(new LottoNumbersWrapper(customCollectNumberList))).isEqualTo(index + 1);
        }
    }

    @Test
    @DisplayName("보너스 숫자 일치 판단 기능 테스트")
    public void isMatchToBonusNumberTest() {
        int collectBonusNumber = testLottoNumbersWrapper.getNumbers().get(0);
        assertThat(testLottoNumbersWrapper.isMatchToBonusNumber(collectBonusNumber)).isTrue();
        assertThat(testLottoNumbersWrapper.isMatchToBonusNumber(NOT_LOTTO_NUMBER)).isFalse();
    }




}