package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.Record;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RecordTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)        // todo) new LottoNumber() 로 테스트 데이터 만드는 것 수정하기
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
        Lotto winLotto = new Lotto(lottoNumberList);
        winNumber = new WinNumber(winLotto);
    }

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void record_DependsOnCount_ChooseFirst() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumberList);
        Record record = Record.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Record.FIRST).isEqualTo(record);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void record_DependsOnCount_ChooseSecond() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(7));
        Lotto lotto = new Lotto(lottoNumberList);
        Record record = Record.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Record.SECOND).isEqualTo(record);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void record_DependsOnCount_ChooseThird() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(7)
                , new LottoNumber(8));
        Lotto lotto = new Lotto(lottoNumberList);
        Record record = Record.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Record.THIRD).isEqualTo(record);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void record_DependsOnCount_ChooseFourth() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(7)
                , new LottoNumber(8)
                , new LottoNumber(9));
        Lotto lotto = new Lotto(lottoNumberList);
        Record record = Record.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Record.FOURTH).isEqualTo(record);
    }

    @DisplayName("2개 이하를 맞힐 경우 에러가 난다.")
    @Test
    public void record_DependsOnCount_ChooseNothing() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(7)
                , new LottoNumber(8)
                , new LottoNumber(9)
                , new LottoNumber(10));
        Lotto lotto = new Lotto(lottoNumberList);
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Record.find(winNumber.distinguish(lotto)));
    }

}
