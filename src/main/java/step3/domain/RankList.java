package step3.domain;

import java.util.List;

public class RankList {
    List<WinInformation> matchtCountList;

    public RankList(List<WinInformation> matchtCountList) {
        this.matchtCountList = matchtCountList;
    }

    public List<WinInformation> getMatchtCountList() {
        return matchtCountList;
    }

    public int match(WinInformation number) {
        return (int) matchtCountList.stream()
                .filter(d -> number == d)
                .count();
    }

    @Override
    public String toString() {
        return "RankList{" +
                "matchtCountList=" + matchtCountList +
                '}';
    }
}
