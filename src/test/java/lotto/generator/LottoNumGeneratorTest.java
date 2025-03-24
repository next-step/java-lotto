package lotto.generator;

import lotto.property.LottoProperty;
import lotto.type.LottoNumList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumGeneratorTest {

  @DisplayName("로또 번호 생성")
  @Test
  void testGenerate() {
    LottoNumGenerator lottoNumGeneratorNotShuffle = candidates -> candidates;
    LottoNumGenerator lottoNumGeneratorReverseShuffle = candidates -> {
      List<Integer> reversed = new ArrayList<>(candidates);
      Collections.reverse(reversed);
      return reversed;
    };

    assertAll(
        () -> assertThat(lottoNumGeneratorNotShuffle.generate())
            .isEqualTo(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6))),
        () -> assertThat(lottoNumGeneratorReverseShuffle.generate())
            .isEqualTo(LottoNumList.valueOf(
                List.of(
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM - 5,
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM - 4,
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM - 3,
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM - 2,
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM - 1,
                    LottoProperty.MAX_LOTTO_CANDIDATE_NUM
                )
            ))
    );
  }
}
