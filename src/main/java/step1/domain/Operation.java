package step1.domain;

/**
 * Operation 인터페이스는 두 개의 Number 객체를 받아서 연산을 수행하는 메서드를 정의한다.
 */
@FunctionalInterface
public interface Operation {
    Number operate(Number left, Number right);
}
