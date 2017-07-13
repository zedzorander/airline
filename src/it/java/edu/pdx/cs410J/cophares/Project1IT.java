package edu.pdx.cs410J.cophares;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * An integration test for the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project1.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
    @Test
    public void testNoCommandLineArgumentsExitsWithCode1() {
        MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    }

    @Test
    public void testNameCommandLineArgument() {
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Delta"));
    }

    @Test
    public void testFlightNumberCommandLineArgument(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("42"));
    }

    @Test
    public void testInvalidFlightNumberCommandLineArgumentExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "Neo", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid Flight Number!"));
    }

    @Test
    public void testSrcCommandLineArgument(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("PDX"));
    }

    @Test
    public void testSrcCommandArgumentOfLengthDifferentThan3ExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PD", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testDepartTimeCommandLineArgument(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("09/28/2017 05:34"));
    }

    @Test
    public void testIncorrectFormatForDepartTimeArgumentExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/207 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testDestCommandLineArgument(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("LAX"));
    }

    @Test
    public void testDestCommandArgumentOfLengthDifferentThan3ExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LA", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testArriveTimeCommandLineArgument(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("09/28/2017 05:34"));
    }

    @Test
    public void testIncorrectFormatForArriveTimeArgumentExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "Delta", "42", "PDX", "09/28/2017 05:34", "LAX", "09/28/217 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testCommandLineArgumentsWithPrintOption(){
        MainMethodResult result = invokeMain(Project1.class, "-print", "Delta", "42", "PDX", "9/28/2017 05:34", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Flight 42 departs PDX at 9/28/2017 05:34 arrives LAX at 9/28/2017 07:34\r\n"));
    }

    @Test
    public void testCommandLineArgumentsWithReadMeOptionExitsWithCodeNegative1(){
        MainMethodResult result = invokeMain(Project1.class, "-README", "Delta", "42", "PDX", "9/28/2017 05:34", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(-1));
        //assertThat(result.getTextWrittenToStandardOut(), containsString("Flight 42 departs PDX at 9/28/2017 05:34 arrives LAX at 9/28/2017 07:34\r\n"));
    }

    @Test
    public void testBothOptionsListedInCommandLineExitsWithCodeNegative1(){
        MainMethodResult result = invokeMain(Project1.class, "-print", "-README", "Delta", "42", "PDX", "9/28/2017 05:34", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(-1));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Flight 42 departs PDX at 9/28/2017 05:34 arrives LAX at 9/28/2017 07:34\r\n"));
    }

    @Test
    public void testBothOptionsListedInCommandLineWithMisspelledOptionExitsWithCodeNegative1(){
        MainMethodResult result = invokeMain(Project1.class, "-prints", "-REAdDME", "Delta", "42", "PDX", "9/28/2017 05:34", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testCommandLineArgumentsWithMisspelledOptionExitsWithCode1(){
        MainMethodResult result = invokeMain(Project1.class, "-steven", "Delta", "42", "PDX", "9/28/2017 05:34", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void testMissingArgumentsWithOptionsExitsWithCode1(){
        MainMethodResult result = invokeMain("-print", "Delta","42", "PDX", "LAX", "9/28/2017 07:34");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }
}