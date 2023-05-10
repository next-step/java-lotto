package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGenerateTest {

    @DisplayName("로또 번호 리스트가 정상적으로 6개인지 테스트")
    @Test
    public void lottoGenerateTest_정상_리스트_사이즈_테스트() {

        assertAll("Lotto size == 6",
                () -> assertEquals(LottoGenerate.initLottoNumbers().size(), 6),
                () -> assertEquals(LottoGenerate.initLottoNumbers().size(), 6),
                () -> assertEquals(LottoGenerate.initLottoNumbers().size(), 6)
        );
    }

    @DisplayName("로또 번호 리스트 숫자들이 1~45 안에 있는지 테스트")
    @Test
    public void lottoGenerateTest_생성_숫자_범위_테스트() {

        assertThat(LottoGenerate.initLottoNumbers().stream()
                .allMatch(num -> num >=1 && num <= 45))
                .isTrue();
    }
}
