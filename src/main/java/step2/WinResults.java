package step2;

import java.util.List;
import java.util.Objects;

public class WinResults {

    private List<WinResult> winResults;

    public WinResults(List<WinResult> winResults) {
        this.winResults = winResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinResults that = (WinResults) o;
        return Objects.equals(winResults, that.winResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winResults);
    }
}
