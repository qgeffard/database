package org.qgeff;

import java.io.*;
import java.util.Optional;
import java.util.stream.Stream;

class Database {
    private static final String SEPARATOR = "%%%";
    public static final String EMPTY = "Empty";
    private File file;

    Database(String s) {
        file = new File(s);
    }

    String get(String key) throws FileNotFoundException {
        BufferedReader in =  new BufferedReader(new FileReader(file));
        Optional<String> val = in.lines().filter(str -> str.startsWith(key)).reduce((first, second) -> second);
        return val.isPresent() ? val.get().split(SEPARATOR)[1] : EMPTY;
    }

    void set(String key, String val) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write(key + SEPARATOR + val + "\n");
        out.close();
    }
}
