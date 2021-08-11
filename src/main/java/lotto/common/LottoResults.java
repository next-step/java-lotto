package lotto.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoResults {

    private final List<LottoResult> elements = new ArrayList<>();

    public void add(LottoResult lottoResult) {
        this.elements.add(lottoResult);
    }

    public void addAll(LottoResult... lottoResults){
        this.elements.addAll(Arrays.asList(lottoResults));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
