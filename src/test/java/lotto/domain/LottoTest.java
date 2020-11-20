package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("구입한 로또가 당첨번호 몇개와 일치하는지 알 수 있다")
    @Test
    void matchedNumberCount(){
        Lotto lotto = issueLotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,10,11,12,13,14)))).isEqualTo(1);
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,2,11,12,13,14)))).isEqualTo(2);
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,2,3,12,13,14)))).isEqualTo(3);
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,2,3,4,13,14)))).isEqualTo(4);
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,2,3,4,5,14)))).isEqualTo(5);
        assertThat(lotto.getMatchedNumberCount(new ListNumberMatcher(Arrays.asList(1,2,3,4,5,6)))).isEqualTo(6);
    }

    @DisplayName("순서와 관계없이 번호가 동일하면 같은 로또다")
    @Test
    void equals(){
        Lotto lotto1 = LottoUtils.lotto("1,2,3,4,5,6");
        Lotto lotto2 = LottoUtils.lotto("2,6,4,5,3,1");

        assertThat(lotto1.equals(lotto2)).isTrue();
    }


    private Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(new LottoNumber(numbers));
    }

}