package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static lotto.common.LottoConstants.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    private Set<LottoNumber> lottoNumberSet;
    private LottoNumbers lottoNumbers;

    @BeforeEach
    public void setup() {
        LottoNumber firstLottoNumber = LottoNumber.valueOf(1);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(2);
        LottoNumber thirdLottoNumber = LottoNumber.valueOf(3);
        LottoNumber fourthLottoNumber = LottoNumber.valueOf(4);
        LottoNumber fifthLottoNumber = LottoNumber.valueOf(5);
        LottoNumber sixthLottoNumber = LottoNumber.valueOf(6);

        lottoNumberSet = new TreeSet<>(Comparator.comparingInt(LottoNumber::number));
        lottoNumberSet.add(firstLottoNumber);
        lottoNumberSet.add(secondLottoNumber);
        lottoNumberSet.add(thirdLottoNumber);
        lottoNumberSet.add(fourthLottoNumber);
        lottoNumberSet.add(fifthLottoNumber);
        lottoNumberSet.add(sixthLottoNumber);

        lottoNumbers = new LottoNumbers(lottoNumberSet);

    }

    @Test
    @DisplayName("로또 번호 리스트 객체 생성")
    public void createLottoNumbers() {
        LottoNumbers createLottoNumbers = new LottoNumbers(lottoNumberSet);
        assertThat(createLottoNumbers.equals(lottoNumbers)).isTrue();
    }


    @Test
    @DisplayName("로또 번호 7개 리스트 객체 생성 실패")
    public void createSevenLottoNumbers() {
        lottoNumberSet.add(LottoNumber.valueOf(7));
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumbers(lottoNumberSet)).withMessage(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
    }

}
