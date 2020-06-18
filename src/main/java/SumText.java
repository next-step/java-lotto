public class SumText {
    private int sum = 0;
    private String[] text;

    public SumText(String[] text) {
        this.text = text;
    }

    public int sum() {
        for (String value : text) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
