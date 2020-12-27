package com.company;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Stein
 * @product IntelliJ IDEA
 * @created on 21/12/2020
 */
public class MapProgram {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a Compiled Hi-Level, OO, Platform independent lang");
        languages.put("Python", "an interpreted, OO, Hi-level programming lang with dynamic semantic");
        languages.put("Algol", "an algorithmic lang");
        languages.put("BASIC", "Beginner All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("java"));
        languages.put("Java", "This course is about Java");
        System.out.println(languages.get("Java"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the Map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("====================================================================");

//        languages.remove("Lisp");

        if (languages.remove("Algol", "an algorithmic lang")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if (languages.replace("Lisp", "will not work","a functional programming language with imperative features")) {
            System.out.println("lisp replace");
        } else {
            System.out.println("lisp was not replace");
        }
//        System.out.println(languages.replace("Scala", "this will not be added"));

        for ( String key: languages.keySet() ) {
            System.out.println(key + " : " + languages.get(key));
        }
    }

}
