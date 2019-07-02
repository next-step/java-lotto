package camp.nextstep.edu.lotto.view.console.formatter;

@FunctionalInterface
public interface Formatter<T> {
    String format(T rawData);
}
