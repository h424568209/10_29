
import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contact {
    Map<String, User> map = new HashMap<>();

    public void add(String name, String privatephone, String officeNumber) throws NameExistException {
        User user = new User(name, privatephone, officeNumber);
        if (map.containsKey(name)) {
            throw new NameExistException();
        }
        map.put(name, user);
    }

    public String search(String name) throws NameNotExistException {
        List<User> list = new ArrayList<>();
        if (map.containsKey(name)) {
            list.add(map.getOrDefault(name, null));
        }
        return list.toString();
    }

    public boolean remove(Contact contact, String name) throws NameNotExistException {
        if (map.containsKey(name)) {
            map.remove(name);
            return true;
        }
        return false;
    }

    public void updata(Contact contact, String name) throws NameNotExistException {
        if (map.containsKey(name)) {

        }

    }

    public User get(String name) {
        return map.get(name);
    }

    public String toString() {
        return map.toString();
    }
}