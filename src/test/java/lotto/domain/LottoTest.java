package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또 번호 개수 테스트")
    public void lotteNumbersSizeTest() {
        Lotto lotto = new Lotto(NumberGenerator.pickLottoNumber());
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(Config.LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("[랜덤 요소 존재] 로또 번호 범위 테스트")
    public void lotteNumbersRangeTest() {
        Lotto lotto = new Lotto(NumberGenerator.pickLottoNumber());
        List<Integer> numbers = lotto.getNumbers();

        for (int number : numbers) {
            assertThat(number).isBetween(Config.LOTTO_NUMBER_RANGE_TO_MIN, Config.LOTTO_NUMBER_RANGE_TO_MAX);
        }
    }

    @Test
    @DisplayName("로또 번호 일치 개수 계산 기능 테스트")
    public void lotteMatchCountTest() {

        List<Integer> lottoNumbers = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            lottoNumbers.add(index + 1);
        }
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> customCollectNumberList = new ArrayList<>();
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            customCollectNumberList.add(index + 1);
            assertThat(lotto.getMatchCount(customCollectNumberList)).isEqualTo(index + 1);
        }

    }
}