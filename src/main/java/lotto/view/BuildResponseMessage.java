package lotto.view;

@FunctionalInterface
public interface BuildResponseMessage<T> {
    String toMessage(T t);
}
