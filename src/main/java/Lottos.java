import java.util.List;

public class Lottos {
    private List<Lotto> value;

    public Lottos(List<Lotto> value) {
        this.value = value;
    }

    public int size() {
        return this.value.size();
    }

    public Lotto findByOrder(int order) {
        return this.value.get(order);
    }

    public List<Lotto> get() {
        return this.value;
    }
}
