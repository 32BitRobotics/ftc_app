package org.firstinspires.ftc.teamcode;

import android.util.Range;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class GoBefungeYourself {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int UP = 3;

    public static void compile(String data) {
        // get map length/height
        int width = 0;
        int height = 0;
        String[] lines = data.split("\n");
        for (String line : lines) {
            height += 1;
            if (line.length() > width)
                width = line.length();
        }

        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            char[] row = new char[width];
            Arrays.fill(row, ' ');
            for (int j = 0; j < lines[i].length(); j++) row[j] = lines[i].charAt(j);
        }

        int direction = RIGHT;
        boolean is_running = true;
        int x = 0;
        int y = 0;
        List<Integer> stack = new ArrayList<Integer>();
        char current;


        while (is_running) {
          if ((0 <= x && x <= width - 1) &&
               0 <= y && y <= height - 1) {

          } else {
              System.out.println("Hit map boundary");
          }
        }
    }
}
