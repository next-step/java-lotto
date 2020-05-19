package splitter;

public interface Splitter {

    String[] EMPTY_ARRAY = new String[] {};

    boolean support(String value);
    String[] split(String value);
}
