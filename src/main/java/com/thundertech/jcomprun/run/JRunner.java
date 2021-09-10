package com.thundertech.jcomprun.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/** JRunner - run provided .java file
 *
 * @author - SerBuryat
 * @version - 0.1
 *
 * **/

public class JRunner {

    /**
     * Run provided .java file.
     *
     * @param javaFile - source code
     * @return - output string from java file if exists.
     *
     * **/
    public static String run(File javaFile) {

        StringBuilder result = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec("java " + javaFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }


}
