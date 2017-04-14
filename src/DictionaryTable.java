import java.util.*;

public class DictionaryTable implements Map<Long, String> {

    private final DictionaryEntry dictionary[];

    DictionaryTable() {
        dictionary = new DictionaryEntry[100];
    }

    DictionaryTable(int MAX) {
        dictionary = new DictionaryEntry[MAX];
    }

    public static void main(String[] args) {
        DictionaryTable dictionary = new DictionaryTable(500);
        System.out.println(dictionary.isEmpty());
        System.out.println(dictionary.size());
        System.out.println(dictionary.put(50L, "Tomasz"));
        dictionary.show();
        System.out.println(dictionary.size());
        System.out.println(dictionary.put(51L, "Micha³"));
        dictionary.show();
        System.out.println(dictionary.size());
        System.out.println(dictionary.get(50L));
        System.out.println(dictionary.containsKey(50L));
        System.out.println(dictionary.containsKey("lol2"));
        System.out.println(dictionary.get(50L));
        System.out.println(dictionary.get("lol"));
        System.out.println(dictionary.remove(50L));
        System.out.println(dictionary.size());
        System.out.println(dictionary.get(50L));
        System.out.println(dictionary.put(53L, "Tomasz"));
        System.out.println(dictionary.put(54L, "Pawlacz"));
        dictionary.put(52L, "Kaœka");
        dictionary.show();
        System.out.println(dictionary.get("Duszek"));
        System.out.println(dictionary.containsKey("Duszek"));
        System.out.println(dictionary.containsKey("Puszek"));
        System.out.println(dictionary.containsValue("Micha³"));
        System.out.println(dictionary.containsValue("Maciej"));
        System.out.println(dictionary.isEmpty());
        System.out.println(dictionary.size());
        System.out.println(dictionary.values());
        System.out.println(dictionary.keySet());
        HashMap<Long, String> map = new HashMap<Long, String>();
        map.put(55L, "Marek");
        map.put(56L, "Yulia");
        dictionary.putAll(map);
        dictionary.show();
        System.out.println(dictionary.isEmpty());
        System.out.println(dictionary.size());
        System.out.println(dictionary.values());
        System.out.println(dictionary.keySet());
        Iterator<Entry<Long, String>> it = dictionary.entrySet().iterator();
        while (it.hasNext()) {
            DictionaryEntry entry = (DictionaryEntry) it.next();
            System.out.printf("%s%-10s%s%s\n", "Dragon: ", entry.get_dragon(), "Owner: ", entry.get_owner());
        }
        System.out.println(dictionary.entrySet().size());
        for (Entry<Long, String> entry : dictionary.entrySet())
            System.out.printf("%s%-10s%s%s\n", "Dragon: ", ((DictionaryEntry) entry).get_dragon(), "Owner: ",
                    ((DictionaryEntry) entry).get_owner());
        dictionary.show();
        dictionary.remove("Duszek");
        dictionary.show();
        dictionary.clear();
        dictionary.show();
        System.out.println(dictionary.isEmpty());
        System.out.println(dictionary.size());
        System.out.println(dictionary.values());
        System.out.println(dictionary.keySet());
        System.out.println(dictionary.size());
        dictionary.put(57L, "Tomasz");
        dictionary.put(58L, "Tomasz");
        dictionary.show();
        System.out.println(dictionary.size());
        for (Entry<Long, String> entry : dictionary.entrySet())
            System.out.printf("%s%-10s%s%s\n", "Dragon: ", ((DictionaryEntry) entry).get_dragon(), "Owner: ",
                    ((DictionaryEntry) entry).get_owner());
        System.out.println(dictionary.size());
    }

    @Override
    public void clear() {
        int size = size();
        for (int i = 0; i < size; i++) {
            dictionary[i] = null;
        }
    }

    @Override
    public boolean containsKey(Object dragon) {
        for (int i = 0; i < size(); i++)
            if (dictionary[i].get_dragon().equals(dragon))
                return true;
        return false;
    }

    @Override
    public boolean containsValue(Object owner) {
        for (int i = 0; i < size(); i++)
            if (dictionary[i].get_owner().equals(owner))
                return true;
        return false;
    }

    @Override
    public Set<java.util.Map.Entry<Long, String>> entrySet() {
        Set<Entry<Long, String>> entrySet = new HashSet<Entry<Long, String>>();
        for (int i = 0; i < size(); i++)
            entrySet.add(dictionary[i]);
        return entrySet;
    }

    @Override
    public String get(Object dragon) {
        for (int i = 0; i < size(); i++)
            if (dictionary[i].get_dragon().equals(dragon))
                return dictionary[i].get_owner();
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }

    @Override
    public Set<Long> keySet() {
        Set<Long> keySet = new HashSet<Long>();
        for (int i = 0; i < size(); i++)
            keySet.add(dictionary[i].get_dragon());
        return keySet;
    }

    @Override
    public String put(Long dragon, String owner) {
        if (isEmpty()) {
            dictionary[0] = new DictionaryEntry(owner, dragon);
            return null;
        }
        for (int i = 0; i < size(); i++)
            if (dictionary[i].get_dragon().equals(dragon)) {
                String previous = dictionary[i].get_owner();
                dictionary[i].set_owner(owner);
                return previous;
            }
        int size = size();
        dictionary[size] = new DictionaryEntry(owner, dragon);
        return null;
    }

    @Override
    public void putAll(Map<? extends Long, ? extends String> oldMap) {
        for (Entry<? extends Long, ? extends String> x : oldMap.entrySet())
            put(x.getKey(), x.getValue());
    }

    @Override
    public String remove(Object dragon) {
        String removed = get(dragon);
        if (removed != null) {
            for (int i = 0; i < size(); i++)
                if (dictionary[i].get_dragon().equals(dragon)) {
                    for (int j = i; j < size(); j++) {
                        dictionary[j] = dictionary[j + 1];
                    }
                    return removed;
                }
        }
        return null;
    }

    @Override
    public int size() {
        int i;
        for (i = 0; i < dictionary.length; i++)
            if (dictionary[i] == null)
                break;
        return i;
    }

    @Override
    public Collection<String> values() {
        Set<String> valuesSet = new HashSet<String>();
        for (int i = 0; i < size(); i++)
            valuesSet.add(dictionary[i].get_owner());
        return valuesSet;
    }

    void show() {
        for (int j = 0; j < size(); j++)
            System.out.println(dictionary[j].get_dragon() + " " + dictionary[j].get_owner());

    }
}
