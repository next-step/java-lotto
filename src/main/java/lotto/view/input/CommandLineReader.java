package lotto.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandLineReader {

    private Scanner scanner = new Scanner(System.in);
    private NumberReader numberReader = new NumberReader();
    private CsvStringReader csvStringReader = new CsvStringReader();

    public Long readNumber() {
        return numberReader.parseInput(scanner.nextLong());
    }

    public List<String> readCsv() {
        return csvStringReader.parseInput(scanner.next());
    }

    public List<Long> readCsvLongValues() {
        return readCsv().stream().map(Long::parseLong).collect(Collectors.toList());
    }

    public static class NumberReader {
        public Long parseInput(Long num) {
            if (num == null || num < 0) {
                throw new IllegalArgumentException("Invalid input");
            }
            return num;
        }
    }

    public static class CsvStringReader {
        private static final String DELIMETER = ",";

        public List<String> parseInput(String str) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("Invalid input");
            }
            return Arrays.asList(str.split(DELIMETER));
        }
    }
}