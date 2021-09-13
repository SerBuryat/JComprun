# JComprun
Compile and run provided java source code inside java code. 

JComprun contatins 2 main functionality: 
 - compile provided java code (create .java and .class files);
 - run java file;
 
 ## Versions

Jdk - 11 (or lower - until 1.8)
 
 ## Installation
 
1. Install in local `.m2` repository 
 
 ```bash
mvn install
```
  and use like a dependency in `pom.xml`.

```xml

<dependencies>
        <dependency>
            <groupId>com.thundertech.jcomprun</groupId>
            <artifactId>JComprun</artifactId>
            <version>0.1</version>
        </dependency>
    </dependencies>
```

  2. Create `.jar` file 

 ```bash
mvn package
```

and add file like an external library to your project ([Intelj Idea](https://www.jetbrains.com/help/idea/working-with-module-dependencies.html#add-a-new-dependency)).



## Usage example

```java

String code = "public class Main {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Main class compiled!\");\n" +
                    "    }\n" +
                    "}";

File javaFile = new JCompiler().compile(code);
String output = JRunner.run(javaFile);

System.out.println(output);
```
In this case, you will see on yout output terminal:
 ```bash
Main class compiled!
```
Produces two files `Main.java` and `Main.class` and saves in directory: 

- default (`/home/user`); 
- set via constructor
```java 

new JCompiler("c://files/") 

```

or setter

```java 

JCompiler compiler = new JCompiler();
compiler.setFilesDirectory("c://files/");

```
