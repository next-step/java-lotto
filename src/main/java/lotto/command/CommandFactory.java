package lotto.command;

import java.util.Set;

public class CommandFactory {
    private static final Set<Command> SUPPORTED_COMMANDS;

    static {
        SUPPORTED_COMMANDS = Set.of(new AddCommand(), new MinusCommand(), new MultiplyCommand(), new DivideCommand());
    }

    public Command getCommand(String operator) {
        return SUPPORTED_COMMANDS.stream()
                                 .filter(command -> command.operator().equalsIgnoreCase(operator))
                                 .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다. 입력값=" + operator));

    }
}
