package lottogame.validator;

public interface InputValidatable<T> {
    boolean isInvalid(T target);
    String getInvalidMessage();

    default void validate(T target) {
        if(isInvalid(target)) {
            throw new IllegalArgumentException(getInvalidMessage());
        }
    }
}