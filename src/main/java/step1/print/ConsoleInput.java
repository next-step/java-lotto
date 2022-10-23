package step1.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    public String inputValue() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        }
    }

}
