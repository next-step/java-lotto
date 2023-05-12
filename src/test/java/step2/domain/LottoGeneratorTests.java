package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTests {
    @Test
    @DisplayName("Lotto 발급처리 확인")
    void generateTotalLotto_ShouldReturnListOfListsOfSizeCountOfLotto() {
        // Given
        int countOfLotto = 5;

        // When
        List<LottoNumber> result = LottoGenerator.generateTotalLotto(countOfLotto);

        // Then
        Assertions.assertThat(result).isNotNull()
                .hasSize(countOfLotto);
    }
}
