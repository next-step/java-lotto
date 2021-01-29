package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketDTO {
    private List<LottoNumberDTO> lottoNumbers;

    public LottoTicketDTO(List<LottoNumberDTO> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (LottoNumberDTO lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.getNumber());
        }
        return numbers;
    }
}
