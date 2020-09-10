package AutoLotto.view;

import java.util.Scanner;
import java.util.*;

public class SystemInput {

    private static final Scanner scanner = new Scanner(System.in);

    public int getIntValue() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            String value = scanner.next();
            throw new InputMismatchException();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        }
    }

    public String getStringValue() {
        return scanner.nextLine();
    }
}
