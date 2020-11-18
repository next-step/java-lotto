package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 인스턴스 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3:5:7", "2:3:5:8"}, delimiter = ':')
    public void createLottoInstanceTest(int sequence, int element2, int element3, int element4) {

        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoMachine() {
            @Override
            public List<Integer> createLottoNumber(List<Integer> lotto) {
                return Arrays.asList(element2, element3, element4);
            }
        });

        //Then
        assertThat(lotto.getLottoPickNumber()).contains(element2, element3, element4);
    }

    @DisplayName("로또 인스턴스 equals 동일 성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1","6:6:6"}, delimiter = ':')
    public void lottoInstanceEqualsSuccessTest(Integer sequence, Integer sequence2, Integer sequence3){
        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoAutoMachine());
        Lotto lotto2 = new Lotto(sequence2, new LottoAutoMachine());
        Lotto lotto3 = new Lotto(sequence3, new LottoAutoMachine());

        //Then
        assertThat(lotto).isEqualTo(lotto2).isEqualTo(lotto3);
    }

    @DisplayName("로또 인스턴스 equals 실패 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3","6:3:5"}, delimiter = ':')
    public void lottoInstanceEqualsFailTest(Integer sequence, Integer sequence2, Integer sequence3){
        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoAutoMachine());
        Lotto lotto2 = new Lotto(sequence2, new LottoAutoMachine());
        Lotto lotto3 = new Lotto(sequence3, new LottoAutoMachine());

        //Then
        assertThat(lotto).isNotEqualTo(lotto2).isNotEqualTo(lotto3);
    }

    @DisplayName("matchPrizeNumber 메서드 실행 후 PrizeInformation 필드 생성여부 확인 테스트")
    @Test
    public void matchPrizeNumberTest(){
        //Given
        Lotto lotto = new Lotto(1, new LottoMachine() {
            @Override
            public List<Integer> createLottoNumber(List<Integer> lotto) {
                return Arrays.asList(1,3,5,6,7,8);
            }
        });

        //When
        lotto.matchPrizeNumber(Arrays.asList(1,3,5,6,7,8));

        //That
        assertThat(lotto.getPrizeInformation()).isEqualTo(PrizeInformation.ALL_MATCH);

    }
}






























