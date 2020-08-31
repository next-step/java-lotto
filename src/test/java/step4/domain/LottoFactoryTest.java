package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.domain.LottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {

    private List<LottoNumber> lottoNumberList;
    Set lottoSet;

    @BeforeEach
    void setUp() {
        lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));
        lottoSet = new HashSet(lottoNumberList);
    }

    @Test
    public void duplicateNumberTest() {
        assertThatThrownBy(() -> {
            LottoFactory.makeLottoWithString("1,1,1,1,1,1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void makeLottoManualTest() {
        Lotto lotto = LottoFactory.makeLottoWithString("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto(lottoSet);
        assertThat(lotto).isEqualTo(lotto2);
    }
}
