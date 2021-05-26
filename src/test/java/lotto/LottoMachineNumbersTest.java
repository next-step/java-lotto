package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.LottoConstants.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineNumbersTest {
    private List<LottoNumber> lottoNumberList;
    private LottoNumbers lottoNumbers;

    @BeforeEach
    public void setup() {
        LottoNumber firstLottoNumber = LottoNumber.lottoNumber(1);
        LottoNumber secondLottoNumber = LottoNumber.lottoNumber(2);
        LottoNumber thirdLottoNumber = LottoNumber.lottoNumber(3);
        LottoNumber fourthLottoNumber = LottoNumber.lottoNumber(4);
        LottoNumber fifthLottoNumber = LottoNumber.lottoNumber(5);
        LottoNumber sixthLottoNumber = LottoNumber.lottoNumber(6);

        lottoNumberList = new ArrayList<>();
        lottoNumberList.add(firstLottoNumber);
        lottoNumberList.add(secondLottoNumber);
        lottoNumberList.add(thirdLottoNumber);
        lottoNumberList.add(fourthLottoNumber);
        lottoNumberList.add(fifthLottoNumber);
        lottoNumberList.add(sixthLottoNumber);

        lottoNumbers = new LottoNumbers(lottoNumberList);

    }

    @Test
    @DisplayName("로또 번호 리스트 객체 생성")
    public void createLottoNumbers() {
        LottoNumbers createLottoNumbers = new LottoNumbers(lottoNumberList);
        assertThat(createLottoNumbers.equals(lottoNumbers)).isTrue();
    }


    @Test
    @DisplayName("로또 번호 7개 리스트 객체 생성 실패")
    public void createSevenLottoNumbers() {
        lottoNumberList.add(LottoNumber.lottoNumber(7));
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumbers(lottoNumberList)).withMessage(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
    }

}
