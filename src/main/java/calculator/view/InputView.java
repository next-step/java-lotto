package calculator.view;

import calculator.domain.ClientResponse;
import java.util.Scanner;

public class InputView {

    private static final String GUID_MESSAGE = "값을 입력해주세요";

    public static ClientResponse clientResponse() {
        printSource(GUID_MESSAGE);
        return new ClientResponse(new Scanner(System.in).next());
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
