package lotto.dto;

import java.util.Objects;

public class LottoNumberDTO {
    private Integer number;

    public LottoNumberDTO(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberDTO that = (LottoNumberDTO) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
