package com.thundertech.jcomprun.compiler;

import lombok.*;

import javax.tools.JavaCompiler;
import javax.tools.Tool;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** JCompiler compile provided java source code.
 *
 * @author - SerBuryat
 * @version - 0.1
 *
 * **/

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JCompiler {

    /** Directory for produced files (.java and .class) **/
    private String filesDirectory =  "/home/user/";

    /** Create .java file with source code and compile it to .class file.
     * Both files saves to default (or set directory)
     *
     * @param sourcecode - source code to compile
     * @return  - file .java with provided sourcecode
     * @see File
     * @see javax.tools.JavaCompiler
     *
     * **/

    public File compile(String sourcecode) {
        File javaFile = new File( filesDirectory + getClassName(sourcecode) + ".java");

        try {
            FileWriter writer = new FileWriter(javaFile);
            writer.write(sourcecode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tool javac = ToolProvider.getSystemJavaCompiler();
        javac.run(null,null,null,javaFile.toString());

        return javaFile;
    }

    /**
     *
     * Return class name from source code.
     *
     * @param sourcecode - source code
     * @return - class name
     *
     * 'public[0] class[1] *class name*[2] '
     *
     * **/
    private String getClassName(String sourcecode) {
        String[] words = sourcecode.split(" ");
        if(words[0].equalsIgnoreCase("public")) {
            return words[2];
        } else {
            return words[1];
        }
    }
}
