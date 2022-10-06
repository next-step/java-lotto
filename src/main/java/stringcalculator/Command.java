package stringcalculator;

@FunctionalInterface
public interface Command {
    Number execute(Number leftNumber, Number rightNumber);
}
