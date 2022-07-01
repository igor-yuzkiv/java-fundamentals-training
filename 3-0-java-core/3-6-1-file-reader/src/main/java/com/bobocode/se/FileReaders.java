package com.bobocode.se;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

/**
 * {@link FileReaders} provides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {


        StringBuilder stringBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(stringBuilder::append);
        } catch (IOException e) {
            return e.getMessage();
        }
        return stringBuilder.toString();


        /*Path filePath = createPatchFromName(fileName);

        try (Stream<String> stream = openFileLinesStream(filePath)) {
            return stream.collect(joining("\n"));
        }*/
    }


    public static Stream<String> openFileLinesStream(Path fileName) {
        try {
            return Files.lines(fileName);
        }catch (IOException e) {
            throw new FileReaderException("Cannot create stream of file lines!", e);
        }
    }


    public static Path createPatchFromName(String name) {
        Objects.requireNonNull(name);
        URL fileUrl = FileReaders.class.getClassLoader().getResource(name);

        try {
            return Paths.get(fileUrl.toURI());
        }catch (URISyntaxException e) {
            throw new FileReaderException("Invalid file URL", e);
        }
    }



}
