package step1.input;

import java.util.Scanner;

public class StringCalculatorInput {

    public static String operation(){
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        } catch (RuntimeException runtimeException) {
            runtimeException.getMessage();
        }
        return null;
    }
}
