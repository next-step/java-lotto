package calculator;

/**
 * Created by wyparks2@gmail.com on 2019-06-20
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Calculator {
    public int add(String text) {
        return text == null || text.isEmpty() ? 0 : Integer.valueOf(text);
    }
}
