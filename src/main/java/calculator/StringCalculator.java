package calculator;

public class StringCalculator {

    public int add(final Text text) {
        return text.isEmpty() ? 0 : sum(convertInts(text.split()));
    }

    private int[] convertInts(final String[] split) throws RuntimeException {
        final int splitLength = split.length;
        final int[] ints = new int[splitLength];
        for (int index = 0; index < splitLength; index++) {
            final String value = split[index];

            int convertValue;
            try {
                convertValue = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }

            if (convertValue < 0) {
                throw new RuntimeException();
            }

            ints[index] = convertValue;
        }
        return ints;
    }

    private int sum(final int[] ints) {
        int sum = 0;
        for (int s : ints) {
            sum += s;
        }
        return sum;
    }

}
