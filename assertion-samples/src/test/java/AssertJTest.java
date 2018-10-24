
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Emily on 2017/3/12.
 */
public class AssertJTest {

    private static Todo todo1;
    private static Todo todo2;
    private static Todo todo3;
    private static List todoList;

    @BeforeClass
    public static void setup() {
        System.out.println("@BeforeClass - setup");
        todo1 = new Todo(1, "AssertJ", "Important", 33);
        todo2 = new Todo(2, "Homecrest", "Important", 18);
        todo3 = new Todo(3, "Junit", "Important", 20);
        todoList = Arrays.asList(todo1, todo2);
    }

    @Test
    public void testBasicAssertion() {
        assertThat(todo1.getName()).isEqualTo("AssertJ");
        assertThat(todo1).isNotEqualTo(todo2);

    }

    @Test
    public void testStringSpecific() {
        assertThat(todo1.getName()).startsWith("Ass")
                .endsWith("rtJ")
                .isEqualToIgnoringCase("assertj");
    }

    @Test
    public void testCollectionSpecific() {
        assertThat(todoList).hasSize(2)
                .contains(todo1, todo2)
                .doesNotContain(todo3);
    }

    @Test
    public void testDescribeWillShowBeforeErrorMessage() {
        assertThat(todo1.getAge()).as("check %s's age", todo1.getName()).isEqualTo(33);
    }

    @Test
    public void testExtracting() {
        assertThat(todoList).extracting("name")
                .contains("AssertJ", "Homecrest");
    }

    @Test
    public void testExtractingWithTuples() {
        assertThat(todoList).extracting("name", "age")
                .contains(tuple("AssertJ", 33),
                        tuple("Homecrest", 18));

    }

    @Test
    public void testExceptionMessage() {
        // Java 8 exception assertion, standard style
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).hasMessage("boom!");
        // BDD style
        Throwable thrown = catchThrowable(() -> {
            throw new Exception("boom!");
        });
        assertThat(thrown).hasMessageContaining("boom");
    }
}
