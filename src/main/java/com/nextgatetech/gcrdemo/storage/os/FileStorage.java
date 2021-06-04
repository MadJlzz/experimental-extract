package com.nextgatetech.gcrdemo.storage.os;

import com.nextgatetech.gcrdemo.engine.ExtractionResult;
import com.nextgatetech.gcrdemo.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileStorage implements Storage {

    private final Logger logger = LoggerFactory.getLogger(FileStorage.class);

    private final String destinationDir;

    public FileStorage() {
        this.destinationDir = ".";
    }

    @Override
    public void store(final ExtractionResult extractionResult) {
        final Path filePath = Paths.get(this.destinationDir, extractionResult.getFilename());
        logger.info(String.format("Storing file [%s] into [%s]", extractionResult.getFilename(), filePath));
        final File f = new File(filePath.toString());
        try (InputStream inputStream = new ByteArrayInputStream(extractionResult.getData())) {
            StreamUtils.copy(inputStream, new FileOutputStream(f));
            logger.info("File has been successfully copied");
        } catch (final IOException err) {
            logger.error("Unable to store data on filesystem", err);
        }
    }

}
