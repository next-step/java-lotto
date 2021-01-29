package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketDTO that = (LottoTicketDTO) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
