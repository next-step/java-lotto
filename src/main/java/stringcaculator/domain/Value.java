package stringcaculator.domain;

public interface Value {
    int intValue();
    Value sum(Value value);
}
