package com.cd.demo.powermock;

import java.io.File;

public class FileDemo {

    public boolean createFile (File file) {

        return file.exists();
    }

    public static int getAge (int a) {
        return a * 10;
    }

    public boolean createNewFile (String path) {

        File file = new File(path);
        return file.exists();
    }
}
