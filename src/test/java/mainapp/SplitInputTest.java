package mainapp;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SplitInputTest {

    String inputString;
    String[] split;

    @Test
    public void splitInputByLineUsingBackslashn() {
        givenInputOf("7219\n7654");
        whenSplitInput();
        thenSplitArraySizeIs(2);
        thenSplitArrayContainsExpected(new String[]{"7219", "7654"});

    }




    private void givenInputOf (String input) {
        inputString = input;
    }

    private void whenSplitInput() {
        split = SplitInput.splitInputByLine(inputString);
    }

    private void thenSplitArraySizeIs(int sizeOfSplit) {
        Assertions.assertThat(split.length).isEqualTo(sizeOfSplit);
    }

    private void thenSplitArrayContainsExpected(String[] expected) {
        Assertions.assertThat(split).containsExactly(expected);
    }
}