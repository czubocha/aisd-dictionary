class DictionaryEntry implements java.util.Map.Entry<Long, String> {

    private String owner;
    private Long dragon;

    DictionaryEntry(String owner, Long dragon) {
        this.owner = owner;
        this.dragon = dragon;
    }

    @Override
    public Long getKey() {
        return get_dragon();
    }

    @Override
    public String getValue() {
        return get_owner();
    }

    @Override
    public String setValue(String newOwner) {
        String previous = owner;
        owner = newOwner;
        return previous;
    }

    String get_owner() {
        return owner;
    }

    void set_owner(String owner) {
        this.owner = owner;
    }

    Long get_dragon() {
        return dragon;
    }

    void set_dragon(Long dragon) {
        this.dragon = dragon;
    }
}