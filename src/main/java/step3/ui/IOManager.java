package step3.ui;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class IOManager {

    private static final IOManager STANDARD_IO_MANAGER = new IOManager(new StandardInput(),
                                                                       new StandardOutput());

    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public static IOManager standardIOManager() {
        return STANDARD_IO_MANAGER;
    }

    public int inputMoney() {
        output.printLine("구입금액을 입력해주세요.");
        return input.nextInt();
    }

    public List<Integer> inputNumbers() {
        input.nextLine();
        String data = input.nextLine();
        return Arrays.stream(data.split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(toList());
    }

    public void printBuyCount(int count) {
        output.printLine(count + "개를 구매했습니다.");
    }

    public void printLine(String text) {
        output.printLine(text);
    }

    public void printMultiLine(List<String> statistics) {
        statistics.forEach(output::printLine);
    }
}
