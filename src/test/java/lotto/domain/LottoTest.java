package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또_숫자_중복_테스트")
    @Test
    void duplicateLottoNumberTest() {
        List<Integer> number = Arrays.asList(42, 21, 23, 41, 42, 43);
        List<LottoNumber> lottoNumber = number.stream().map(LottoNumber::new)
            .collect(Collectors.toList());
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(lottoNumber));
    }

    @DisplayName("생성된_로또_넘버_반환_테스트")
    @Test
    void createLottoNumberTest() {
        Lotto lotto = new Lotto("45, 21, 23, 41, 42, 43");
        assertThat(
            Arrays.asList(45, 21, 23, 41, 42, 43).stream().collect(Collectors.toList())).isEqualTo(
            lotto.getLottoNumbers());
    }

    @DisplayName("생성된_로또_번호_개수와_당첨된_로또_번호_개수비교_테스트")
    @Test
    void compareLottoNumberTest() {
        Lotto lotto = new Lotto("45, 21, 23, 41, 42, 43");
        assertThat(lotto.countMatch(new Lotto("45, 21, 23, 41, 42, 1")))
            .isEqualTo(5);
    }

    @DisplayName("전달받은_로또_번호가_로또_번호들에_포함되어있는지_테스트")
    @Test
    public void containsLottoNumberTest() {
        Lotto lotto = new Lotto("45, 21, 23, 41, 42, 43");
        assertTrue(lotto.isContainsConvertInt(new LottoNumber(45)));
    }
}
