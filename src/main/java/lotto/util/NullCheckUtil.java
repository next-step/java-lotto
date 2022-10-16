package lotto.util;

import java.util.Objects;

public class NullCheckUtil {

    private NullCheckUtil() {
        throw new AssertionError("NullCheckUtil 클래스의 기본 생성자는 사용할 수 없습니다.");
    }

    public static void validate(Object object) {
        if (Objects.isNull(object)) {
            throw NullCannotBeConstructorArgException.getInstance();
        }
    }
}
