package in.ushatech;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NameList {
    private List<String> list = Collections.synchronizedList(new LinkedList<>());

    public synchronized void add(String name) {
        list.add(name);
    }

    public synchronized String removeFirst() {
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        return null;
    }
}
