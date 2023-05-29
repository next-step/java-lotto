package lotto.domain;

@FunctionalInterface
interface ThrowableFunctionalInterface<T, R, E extends  Exception> {
    R apply(T t) throws E;
}