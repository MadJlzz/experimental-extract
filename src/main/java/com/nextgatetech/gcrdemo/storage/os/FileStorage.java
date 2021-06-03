package com.nextgatetech.gcrdemo.storage.os;

import com.nextgatetech.gcrdemo.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.file.Path;

@Component
public class FileStorage implements Storage {

    private final Logger logger = LoggerFactory.getLogger(FileStorage.class);

    private final Path destination;

    public FileStorage() {
        this.destination = Path.of("./test.csv");
    }

    @Override
    public void store(final byte[] data) {
        final File f = new File(destination.toString());
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            StreamUtils.copy(inputStream, new FileOutputStream(f));
        } catch (final IOException err) {
            logger.error("Unable to store data on filesystem", err);
        }
    }

}
