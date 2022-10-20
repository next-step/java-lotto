package step1;

public class Pair<V1, V2> {
    private final V1 v1;
    private final V2 v2;

    public Pair(V1 v1, V2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public V1 first() {
        return v1;
    }

    public V2 second() {
        return v2;
    }
}
