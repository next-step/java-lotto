package calculator.model;

import java.util.List;

public abstract class Collection<T> {

    protected List<T> values;

    public abstract void add(T t);

    public abstract void addAll(Collection<T> collection);
}
