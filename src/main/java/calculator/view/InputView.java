package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static String input() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner.next();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expression="";
        try {
            expression = bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return expression;
    }
}
