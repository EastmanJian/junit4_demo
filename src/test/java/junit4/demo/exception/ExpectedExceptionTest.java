package junit4.demo.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ExpectedExceptionTest {
    /**
     * This code under test should throw an IndexOutOfBoundsException. The @Test annotation has an optional parameter
     * "expected" that takes as values subclasses of Throwable. The codes below verify if ArrayList throws the correct
     * exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }


    /**
     * Test the value of the message in the exception using try-catch and matchers
     */
    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }


    /**
     * Use the ExpectedException rule. This rule lets you indicate not only what exception you are expecting, but
     * also the exception message you are expecting
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(containsString("Size: 0"));
        list.get(0); // execution will never get past this line
    }
}
