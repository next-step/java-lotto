package study.calculator.argument;

import java.util.List;
import study.calculator.Number;

/**
 * 입력값을 종류에 따라 분류하여 보관하는 책임
 */
public interface Argument {

    List<Number> parseToNumber();
}
