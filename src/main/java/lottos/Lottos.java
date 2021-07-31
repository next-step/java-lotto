package lottos;

import java.util.List;

public class Lottos {

    private List<Lotto> elements;

    public Lottos(List<Lotto> lottos) {
        this.elements = lottos;
    }

    public Integer size() {
        return elements.size();
    }
}
