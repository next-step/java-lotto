package lotto;

import lotto.model.LottoNumberMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMakerTest {

    @Test
    @DisplayName("랜덤 번호 생성 테스트")
    public void numberTest(){
        LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
        List<Integer> numbers = lottoNumberMaker.makeNumber();
        assertThat(numbers.size()).isEqualTo(6);
    }
}
