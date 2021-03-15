package step2.dto;

import step2.domain.Lotto;
import step2.domain.LottoNumber;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class LottoDto {

    private final List<Integer> lottoNubers;

    public LottoDto(Lotto lottoNumbers) {
        this.lottoNubers = lottoNumbers.toNumberList()
                .stream()
                .map(LottoNumber::toNumber)
                .collect(toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNubers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoDto lottoDto = (LottoDto) o;
        return Objects.equals(lottoNubers, lottoDto.lottoNubers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNubers);
    }
}
