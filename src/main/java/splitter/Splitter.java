package splitter;

public interface Splitter {

    String[] EMPTY_ARRAY = new String[0];

    boolean support(String value);
    String[] split(String value);
}
