package com.company;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static final String EXPORT_HISTORY_FILE_NAME = "script.xls";

    public static void main(String[] args) throws IOException {
	// write your code here
        Parser parser = new Parser();
        parser.parse();
    }
static class Parser{
    public void parse() throws IOException {
        List<String> pd1 = new ArrayList<>(),
                pd2 = new ArrayList<>(),
                pd0 = new ArrayList<>(),
                pd3 = new ArrayList<>();

        File file = new File("/Users/piksai/IdeaProjects/nti_parser/src/com/company/tracker.log");

        Scanner scnr = new Scanner(file);
        while(scnr.hasNextLine()){
            String[] line = scnr.nextLine().split(" ");
            /*pd1.add(Integer.getInteger(line[1]));
            pd2.add(Integer.getInteger(line[2]));
            pd3.add(Integer.getInteger(line[3]));*/
            /*System.out.println(line[2]);
            pd0.addAll(
                    Arrays.asList(line[3].split("\n"))
                            .stream()
                            .collect(Collectors.toList()));
            pd1.addAll(
                    Arrays.asList(line[2].split("\n"))
                    .stream()
                    /*.map(elem -> {
                        //System.out.println("a" + elem);
                        if(!elem.startsWith("0"))
                            return "198";
                        return elem;
                    })*/
                  //  .collect(Collectors.toList()));
            pd0.add(line[3]);
            pd1.add(line[0]);
        }
        int count = 0;
        String begin = "";
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < pd1.size(); i++){

            if(i < 1)
                continue;
            if(pd1.get(i).startsWith(pd1.get(i - 1))){
                count++;
            }else{
                if(count > 1) {
                    //System.out.println(pd1.get(i));
                    System.out.println(" (" + begin + ";" + pd1.get(i) + ";" + pd0.get(i) + ") ");
                    count = 0;
                    begin = pd0.get(i);

                }

                /*else
                    System.out.print(0);*/
            }
        }
        //System.out.println(pd1);
    }
}
}
