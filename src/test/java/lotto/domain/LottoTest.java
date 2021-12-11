package lotto.domain;

import lotto.strategy.CreationLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private List<LottoNumber> lottoNumbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    public void 문자_로또_비교() {
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7"})
    public void 로또_번호_개수_체크(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"-1,0,1,2,3,4", "1,2,3,4,45,46"})
    public void 숫자_1이상_45이하의_입력시_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"ONE,2,3,4,5,6", "하나,2,3,4,5,6"})
    public void 문자_오입력시_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_꽝_맞힌_횟수() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,34,35,45,36", "7");
        assertThat(lotto.matchCountLottoNumbers(prizeLotto)).isEqualTo(2);
    }

    @Test
    public void 로또_상금_맞힌_횟수() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,45,36", "7");
        assertThat(lotto.matchCountLottoNumbers(prizeLotto)).isEqualTo(4);
    }

    @Test
    public void 정적_팩토리() {
        Lotto compareLotto = lotto.getAutoLotto(new CreationLottoNumber() {
            @Override
            public List<LottoNumber> automatic() {
                return new Lotto("1,2,3,4,5,6").getLottoNumbers();
            }
        });
        assertThat(compareLotto).isEqualTo(lotto);
    }
}
