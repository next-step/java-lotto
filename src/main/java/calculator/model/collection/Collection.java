package calculator.model.collection;

import java.util.ArrayList;
import java.util.List;

public class Collection<T> {

    protected List<T> values;

    protected Collection() {
        this.values = new ArrayList<>();
    }

    public void add(T t) {
        this.values.add(t);
    }

    public void addAll(Collection<T> collection) {
        this.values.addAll(collection.values);
    }
}
