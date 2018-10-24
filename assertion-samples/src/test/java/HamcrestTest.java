
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Emily on 2017/3/12.
 */
public class HamcrestTest {
    @Test
    public void testRegularExpressionMatcher() throws Exception {
        String s = "aaabbbaaaa";
        assertThat(s, RegexMatcher.matchesRegex("a*b*a*"));
    }

    @Test
    public void hasSizeOf3() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
    }

    @Test
    public void containsNumbersInAnyOrder() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, containsInAnyOrder(2, 4, 5));
    }

    @Test
    public void everyItemGreaterThan1() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, everyItem(greaterThan(1)));
    }

    @Test
    public void objectHasCorrectSummaryValue() {
        Todo todo = new Todo(1, "Hamcrest", "Important", 18);
        assertThat(todo, hasProperty("name", equalTo("Hamcrest")));
    }

    @Test
    public void isStringEmptyOfNull() {
        String stringToTest = "";
        assertThat(stringToTest, isEmptyOrNullString());
    }

}
