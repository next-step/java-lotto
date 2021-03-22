/*
 * 원시값으로 포장했던 객체 내부의 값을 반환해주는 mapper 클래스
 * */
package Calculator;

import java.lang.reflect.Field;

public class Mapper {

    /*
     * field 접근 공통로직을 수행한다.
     * */
    public static Field mapper(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
     * operand로 인자를 받아, 접근가능한 field를 이용해 int형의 operand를 반환한다.
     * */
    public static int operandToInt(Operand operand) {
        try {
            return mapper(operand, "operand").getInt(operand);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /*
     * delimiter로 인자를 받아, 접근가능한 field를 이용해 int형의 operand를 반환한다.
     * */
    public static String delimiterToString(Delimiter delimiter) {
        try {
            return (String) mapper(delimiter, "delimiter").get(delimiter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
