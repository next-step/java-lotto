package calculator.to;

public class StringSumCalculatorInput {
    private String delimiter;
    private String parameters;

    private StringSumCalculatorInput(String delimiter, String parameters) {
        this.delimiter = delimiter;
        this.parameters = parameters;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getParameters() {
        return parameters;
    }

    public static class Builder {
        private String delimiter;
        private String parameters;

        public Builder() {
        }

        public Builder delimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder parameters(String parameters) {
            this.parameters = parameters;
            return this;
        }

        public StringSumCalculatorInput build() {
            return new StringSumCalculatorInput(delimiter, parameters);
        }
    }
}
