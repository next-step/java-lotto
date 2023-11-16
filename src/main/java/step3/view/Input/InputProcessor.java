package step3.view.Input;

import java.util.Optional;
import java.util.Scanner;

public abstract class InputProcessor<T> {

    public Optional<T> processInput(Scanner scanner) {
        try {
            T input = process(scanner);
            return Optional.of(input);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public abstract T process(Scanner scanner);
}
