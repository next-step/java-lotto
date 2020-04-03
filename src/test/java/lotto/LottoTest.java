package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTest {
    private List<LottoNumber> lotto = new ArrayList<>();

    @BeforeEach
    void setUp(){
        for(int i=1; i<=6; i++){
            lotto.add(new LottoNumber(i));
        }
    }

    @DisplayName("LottoNumber 객체 6개를 주면 정상적으로 Lotto 객체 생성")
    @Test
    void createTest() {
        assertThatCode(() -> new Lotto(lotto)).doesNotThrowAnyException();
    }
}
