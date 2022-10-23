import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest  {

    private final QuickSort<User> quickSort = new QuickSort<>();

    @Test
    public void whenQuickSortUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(4, "Alex"));
        users.add(new User(7, "Jhon"));
        users.add(new User(2, "Igor"));
        users.add(new User(1, "Alex2"));
        quickSort.quickSort(users, 0, users.size() - 1);
        List<User> expected = Arrays.asList(new User(1, "Alex2"),
                (new User(2, "Igor")),
                new User(4, "Alex"),
                new User(7, "Jhon"));
        assertThat(users).usingRecursiveComparison().isEqualTo(expected);
    }
}
