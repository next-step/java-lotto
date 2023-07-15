package lottogame.domain.response;

import java.util.Map;
import java.util.Objects;

public class LottoCheckedResponse {

    private final double earningRate;
    private final Map<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses;

    public LottoCheckedResponse(double earningRate,
        Map<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses) {
        this.earningRate = earningRate;
        this.lottoTicketCheckResponses = lottoTicketCheckResponses;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<LottoTicketCheckedResponse, Integer> getLottoTicketCheckResponses() {
        return lottoTicketCheckResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCheckedResponse)) {
            return false;
        }
        LottoCheckedResponse that = (LottoCheckedResponse) o;
        return Double.compare(that.earningRate, earningRate) == 0 && Objects.equals(
            lottoTicketCheckResponses, that.lottoTicketCheckResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate, lottoTicketCheckResponses);
    }

    @Override
    public String toString() {
        return "LottoCheckResponse{" +
            "earningRate=" + earningRate +
            ", lottoTicketCheckResponses=" + lottoTicketCheckResponses +
            '}';
    }
}
