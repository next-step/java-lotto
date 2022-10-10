package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private static Lotto lotto;
    private static final int NOT_LOTTO_NUMBER = -1;

    @BeforeAll
    static void getTestLottoNumbersWrapper() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            lottoNumbers.add(index + 1);
        }
        lotto = new Lotto(new LottoNumbersWrapper(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호 개수 테스트")
    public void lotteNumbersSizeTest() {
        assertThat(lotto.getNumbers()).hasSize(Config.LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("[랜덤 요소 존재] 로또 번호 범위 테스트")
    public void lotteNumbersRangeTest() {
        for (int number : lotto.getNumbers()) {
            assertThat(number).isBetween(Config.LOTTO_NUMBER_RANGE_TO_MIN, Config.LOTTO_NUMBER_RANGE_TO_MAX);
        }
    }

    @Test
    @DisplayName("로또 번호 일치 개수 계산 기능 테스트")
    public void getMatchCountTest() {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> customCollectNumberList = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            customCollectNumberList.add(numbers.get(index));
            assertThat(lotto.getMatchCount(new LottoNumbersWrapper(customCollectNumberList))).isEqualTo(index + 1);
        }
    }

    @Test
    @DisplayName("보너스 숫자 일치 판단 기능 테스트")
    public void isMatchToBonusNumberTest() {
        int collectBonusNumber = lotto.getNumbers().get(0);
        assertThat(lotto.isMatchToBonusNumber(collectBonusNumber)).isTrue();
        assertThat(lotto.isMatchToBonusNumber(NOT_LOTTO_NUMBER)).isFalse();
    }


}