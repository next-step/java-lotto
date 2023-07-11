package lottogame.service.reponse;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoPurchaseResponse {

    private final List<LottoNumbers> lottoNumbers;

    public LottoPurchaseResponse(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoPurchaseResponse)) {
            return false;
        }
        LottoPurchaseResponse that = (LottoPurchaseResponse) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoPurchaseResponse{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
    }

    public static class LottoNumbers {

        private final Set<Integer> values;

        public LottoNumbers(Set<Integer> values) {
            this.values = values;
        }

        public Set<Integer> getValues() {
            return values;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LottoNumbers)) {
                return false;
            }
            LottoNumbers that = (LottoNumbers) o;
            return Objects.equals(values, that.values);
        }

        @Override
        public int hashCode() {
            return Objects.hash(values);
        }

        @Override
        public String toString() {
            return "LottoNumbers{" +
                "values=" + values +
                '}';
        }
    }
}
