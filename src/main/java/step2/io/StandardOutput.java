package step2.io;

public class StandardOutput implements Output {
    @Override
    public void write(final String line) {
        System.out.println(line);
    }
}
