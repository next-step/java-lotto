package lotto.step2fixture.dto;

import lotto.step2.dto.LottoNumberDTO;
import lotto.step2fixture.domain.LottoNumberFixture;

public class LottoNumberDTOFixture {
    public static final LottoNumberDTO LOTTO_NUMBER_DTO = new LottoNumberDTO(LottoNumberFixture.ONE.lottoNumberInformation().getLottoNumber());
}
