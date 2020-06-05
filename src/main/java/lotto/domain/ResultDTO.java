package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResultDTO {

    private Map<Prize, List<Lotto>> result;
    private double profitRatio;

    public ResultDTO(Map<Prize, List<Lotto>> result, double profitRatio) {
        this.result = result;
        this.profitRatio = profitRatio;
    }

    public Map<Prize, List<Lotto>> getResult() {
        return result;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO resultDTO = (ResultDTO) o;
        return Double.compare(resultDTO.profitRatio, profitRatio) == 0 &&
                Objects.equals(result, resultDTO.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, profitRatio);
    }
}
