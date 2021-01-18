package com.pet.project;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class CleanupApp {

    public static void main(String[] args) throws IOException {

        String url = "D:\\projects";
        deleteBuilds(new File(url));
    }

    static boolean deleteBuilds(File directoryToBeDeleted) throws IOException {
        File[] folders = directoryToBeDeleted.listFiles(File::isDirectory);
        if (folders != null) {
            for (File folder : folders) {
                if (folder.getName().endsWith("build")
                        || folder.getName().endsWith("build-gradle")
                        || folder.getName().endsWith(".gradle")
                        || folder.getName().endsWith("node_modules")
                        || folder.getName().endsWith("out")
                        || folder.getName().endsWith("target")
                ) {
                    FileUtils.deleteDirectory(folder);
                } else {
                    deleteBuilds(folder);
                }
            }
        }
        return true;
    }

}



