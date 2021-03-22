package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> numbers = new ArrayList<>();

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumbers(List<LottoNumber> numbers){
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
