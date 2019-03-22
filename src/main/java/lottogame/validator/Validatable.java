package lottogame.validator;

public interface Validatable<T> {

    boolean isValid(T target);

    default boolean isInvalid(T target) {
        return !isValid(target);
    }

    default String getInvalidMessage() {
        return "잘못된 입력값입니다.";
    }

    default void validate(T target) {
        if (isInvalid(target)) {
            throw new IllegalArgumentException(getInvalidMessage());
        }
    }
}