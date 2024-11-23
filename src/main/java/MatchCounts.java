import java.util.ArrayList;

public class MatchCounts {
    private final ArrayList<MatchCount> values;

    public MatchCounts() {
        this.values = new ArrayList<>();
    }

    public void add(MatchCount matchCount) {
        this.values.add(matchCount);
    }

    public void add(int matchInteger){
        this.values.add(new MatchCount(matchInteger));
    }

    public void clear(){
        this.values.clear();
    }

    public long count(MatchCount matchCount) {
        return this.values.stream()
                .filter(m -> m.equals(matchCount))
                .count();
    }
}
