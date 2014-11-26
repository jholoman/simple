package com.loudacre.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loudacre.kafka.util.EventUtils;

import java.io.IOException;

/**
 * Created by jholoman on 11/21/14.
 */
public class App {
    public static void main( String[] args ) throws IOException, InterruptedException, ClassNotFoundException, JsonProcessingException, Exception
    {

        if (args.length == 0) {
            System.out.println("---------");
            System.out.println("App <cmd> ");
            System.out.println("");
            System.out.println("Consumer");
            System.out.println("Producer");
            System.out.println("WriteTest");
            System.out.println("GC");
            System.out.println("---------");
            return;
        }

        String cmd = args[0];
        String[] subArgs = new String[args.length -1];
        System.arraycopy(args, 1, subArgs, 0, subArgs.length);

        if (cmd.equals("Consumer") || cmd.length() == 0) {
            ConsumerTest.main(subArgs);
        } else if (cmd.equals("Producer")) {
            ProducerTest.main(subArgs);
        } else if (cmd.equals("WriteTest")) {
            EventUtils.main(subArgs);
        } else if (cmd.equals("GC")) {
           System.out.println(EventUtils.SortGroupConcat());
        } else {
            System.out.println("Unknown cmd:" + args[0]);
        }
    }

    }



