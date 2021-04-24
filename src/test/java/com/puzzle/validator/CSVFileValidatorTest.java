package com.puzzle.validator;

import com.puzzle.exception.EmptyFileException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CSVFileValidatorTest {

    @Test
    public void throw_an_exception_when_the_file_does_not_exist() {
        assertThatThrownBy(
                () -> new CSVFileValidator().validate("notExistingFile.txt"))
                .isInstanceOf(FileNotFoundException.class)
                .hasMessage("Error: Cannot find the file with filename : notExistingFile.txt");
    }

    @Test
    public void throw_an_exception_when_the_file_is_empty() {
        // when and then
        assertThatThrownBy(() -> new CSVFileValidator().validate("emptyFile.txt"))
                .isInstanceOf(EmptyFileException.class)
                .hasMessage("Error: The file is empty");
    }

    @Test
    public void throw_an_exception_when_the_file_contains_not_number_value() {
        // when and then
        assertThatThrownBy(
                () -> new CSVFileValidator().validate("containsNotNumberValue.txt"))
                .isExactlyInstanceOf(NumberFormatException.class)
                .hasMessage("Error: Numeric validation failed For input string: \"a\"");
    }

    @Test
    public void throw_an_exception_when_the_file_has_not_the_correct_size() {
        // when and then
        assertThatThrownBy(
                () -> new CSVFileValidator().validate("gridNotCorrectSize.txt"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void return_false_for_a_non_valid_file() throws IOException, EmptyFileException {
        // when
        boolean result = new CSVFileValidator().validate("nonValidFile.txt");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void return_true_for_a_valid_file() throws IOException, EmptyFileException {
        // when
        boolean result = new CSVFileValidator().validate("validFile.txt");

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void return_true_for_a_valid_file_with_a_hole() throws IOException, EmptyFileException {
        // when
        boolean result = new CSVFileValidator().validate("validFileWithAHole.txt");

        // then
        assertThat(result).isTrue();
    }
}
