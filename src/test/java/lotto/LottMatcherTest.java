package lotto;

import lotto.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoDetailMatch;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottMatcherTest {

    List<LottoDetailMatch> matchedLottoList = new ArrayList<>();
    List<Lotto> lottoList;

    @BeforeEach
    public void setup() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoMatcher lottoMatcher = new LottoMatcher(lottoGenerator, "1,2,3,4,5,6");
        int bonusNumber = 7;

        lottoList = lottoGenerator.chooseLottoNumber(10000);
        matchedLottoList = lottoMatcher.matchLottoNumber(lottoList, bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "-2"})
    @DisplayName("LottoRank라는 Enum클래스 값을 테스트한다.")
    public void checkLottoRank(String values) {
        assertThat(LottoRank.findByCount(Integer.parseInt(values), true)).isEqualTo(LottoRank.NON_WINNER);
    }

    @Test
    @DisplayName("번호가 몇개일치하는지 확인한다.")
    public void countMatchedNumbers() {
        assertThat(lottoList.size()).isEqualTo(matchedLottoList.size());
    }
}
