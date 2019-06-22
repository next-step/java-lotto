package calculator;

/**
 * Created by wyparks2@gmail.com on 2019-06-20
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Calculator {
    public int add(String text) {
        String[] tokens = split(text);

        int total = 0;
        for (String token : tokens) {
            total = total + Integer.valueOf(token);
        }

        return total;
    }

    private String[] split(String text) {
        return text == null || text.isEmpty() ? new String[0] : text.split(",");
    }
}
