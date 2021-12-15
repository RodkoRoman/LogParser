package org.rodko.logparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {
    public List<String> readTxt(File file) throws IOException {

        List<String> arrayStrings = new ArrayList<String>();

        File[] arrayFiles = getFilesFromDirectory(file);
        for (File f : arrayFiles) {
            List<String> strings = readsFileAndPullsOutListOfLines(f);
            arrayStrings.addAll(strings);
        }
        return arrayStrings;
    }

    private File[] getFilesFromDirectory(File file){
        return file.listFiles();
    }

    private List<String> readsFileAndPullsOutListOfLines(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }


}
