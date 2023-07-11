package lottogame.service.reponse;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoPurchaseResponse {

    private final List<LottoNumbersResponse> lottoNumberResponses;

    public LottoPurchaseResponse(List<LottoNumbersResponse> lottoNumberResponses) {
        this.lottoNumberResponses = lottoNumberResponses;
    }

    public List<LottoNumbersResponse> getLottoNumbers() {
        return lottoNumberResponses;
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
        return Objects.equals(lottoNumberResponses, that.lottoNumberResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberResponses);
    }

    @Override
    public String toString() {
        return "LottoPurchaseResponse{" +
            "lottoNumberResponses=" + lottoNumberResponses +
            '}';
    }

    public static class LottoNumbersResponse {

        private final Set<Integer> values;

        public LottoNumbersResponse(Set<Integer> values) {
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
            if (!(o instanceof LottoNumbersResponse)) {
                return false;
            }
            LottoNumbersResponse that = (LottoNumbersResponse) o;
            return Objects.equals(values, that.values);
        }

        @Override
        public int hashCode() {
            return Objects.hash(values);
        }

        @Override
        public String toString() {
            return "LottoNumbersResponse{" +
                "values=" + values +
                '}';
        }
    }
}
