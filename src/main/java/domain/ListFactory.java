package domain;

public interface ListFactory {

    public <T> T extractToList(String[] splits);
}
