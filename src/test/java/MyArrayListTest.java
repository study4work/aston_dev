import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest {

    private MyList<User> users = new MyArrayList<>();

    private void addUsers() {
        users.add(new User(4, "Alex"));
        users.add(new User(7, "Jhon"));
        users.add(new User(2, "Igor"));
        users.add(new User(1, "Alex2"));
    }

    @Test
    public void add() {
        addUsers();
        assertThat(new User(4, "Alex")).usingRecursiveComparison().isEqualTo(users.get(0));

    }

    @Test
    public void remove() {
        User user = new User(7, "Jhon");
        addUsers();
        users.add(user);
        users.remove(user);
        assertThat(new User(1, "Alex2")).usingRecursiveComparison().isEqualTo(users.get(3));

    }

    @Test
    public void clear() {
        addUsers();
        users.clear();
        assertThat(users.size()).usingRecursiveComparison().isEqualTo(0);
    }

    @Test
    public void get() {
        addUsers();
        User user = users.get(0);
        assertThat(user).usingRecursiveComparison().isEqualTo(new User(4, "Alex"));
    }

    @Test
    public void set() {
        addUsers();
        users.set(0, new User(1, "Alex2"));
        assertThat(users.get(0)).usingRecursiveComparison().isEqualTo(new User(1, "Alex2"));
    }

    @Test
    public void testAdd() {
        users.add(2, new User(1, "Alex2"));
        assertThat(users.get(2)).usingRecursiveComparison().isEqualTo(new User(1, "Alex2"));
    }

    @Test
    public void testRemove() {
        addUsers();
        users.remove(2);
        assertThat(new User(1, "Alex2")).usingRecursiveComparison().isEqualTo(users.get(2));
    }

    @Test
    public void size() {
        addUsers();
        assertThat(4).usingRecursiveComparison().isEqualTo(users.size());
    }

    @Test
    public void isEmpty() {
        assertThat(true).isEqualTo(users.isEmpty());
    }

    @Test
    public void contains() {
        User user = new User(7, "Jhon");
        users.add(user);
        addUsers();
        assertThat(users.contains(user)).isEqualTo(true);
    }

    @Test
    public void indexOf() {
        User user = new User(7, "Jhon");
        users.add(user);
        assertThat(0).usingRecursiveComparison().isEqualTo(users.indexOf(user));
    }

    @Test
    public void subList() {
        addUsers();
        MyList<User> list = users.subList(1, 2);
        assertThat(new User(7, "Jhon")).usingRecursiveComparison().isEqualTo(list.get(0));
        assertThat(new User(2, "Igor")).usingRecursiveComparison().isEqualTo(list.get(1));
    }
}