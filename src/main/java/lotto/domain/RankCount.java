package lotto.domain;

public class RankCount {

    private Integer count;

    public RankCount(Integer count) {
        this.count = count;
    }

    public RankCount rankCountPlusOne() {
        return new RankCount(count + 1);
    }

    public Integer getCount() {
        return count;
    }
}
