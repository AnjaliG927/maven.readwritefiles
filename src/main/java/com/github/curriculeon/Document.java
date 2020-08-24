package com.github.curriculeon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
        this.fileReader=new FileReader(file);
    }

    @Override
    public void write(String contentToBeWritten) {

        try {
                fileWriter.write(contentToBeWritten);
                fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {


    }

    @Override
    public String read(Integer lineNumber) {
        return null;
    }

    @Override
    public String read() {
        int charRead;
        String readFile="";
        try {
            while ((charRead = fileReader.read()) != -1) {
                readFile += "" + ((char) charRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return readFile;
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {

    }

    @Override
    public void overWrite(String content) {
    }

    public List<String> toList() {
        String content=this.read();
        List<String> contentList=Stream.of(content).collect(Collectors.toList());
        return contentList;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
