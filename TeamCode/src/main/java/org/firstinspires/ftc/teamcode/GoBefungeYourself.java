package org.firstinspires.ftc.teamcode;

import android.util.Range;

import java.security.Policy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class GoBefungeYourself {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int UP = 3;

    private static int[] dirMove(int x,int y,int direction) {
        switch(direction) {
            case RIGHT:
                x += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case DOWN:
                y -= 1;
                break;
            case UP:
                y += 1;
                break;
        }

        int[] i = new int[2];
        i[0] = x;
        i[1] = y;
        return i;
    }

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
        int a,b;
        int[] xy;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char current;

        while (is_running) {
          if ((0 <= x && x <= width - 1) &&
               0 <= y && y <= height - 1) {
              current = map[y][x];

              switch (current) {
                  case '>':
                      direction = RIGHT;
                      break;
                  case '<':
                      direction = LEFT;
                      break;
                  case '^':
                      direction = UP;
                      break;
                  case 'v':
                      direction = DOWN;
                      break;
                  case '#':
                      xy = dirMove(x,y,direction);
                      x = xy[0];
                      y = xy[1];
                      break;
                  case '0':
                      stack.add(0);
                      break;
                  case '1':
                      stack.add(1);
                      break;
                  case '2':
                      stack.add(2);
                      break;
                  case '3':
                      stack.add(3);
                      break;
                  case '4':
                      stack.add(4);
                      break;
                  case '5':
                      stack.add(5);
                      break;
                  case '6':
                      stack.add(6);
                      break;
                  case '7':
                      stack.add(7);
                      break;
                  case '8':
                      stack.add(8);
                      break;
                  case '9':
                      stack.add(9);
                      break;
                  case '+':
                      a = stack.pop();
                      b = stack.pop();
                      stack.add(a+b);
                      break;
                  case '-':
                      a = stack.pop();
                      b = stack.pop();
                      stack.add(b-a);
                      break;
                  case '*':
                      a = stack.pop();
                      b = stack.pop();
                      stack.add(a*b);
                      break;
                  case '/':
                      a = stack.pop();
                      b = stack.pop();
                      stack.add(b/a);
                      break;
                  case '|':
                      a = stack.pop();
                      if (a != 0) direction = UP;
                      else direction = DOWN;
                      break;
                  case '@':
                      is_running = false;
                      break;

              }

              xy = GoBefungeYourself.dirMove(x,y,direction);
              x = xy[0];
              y = xy[1];
          } else {
              System.out.println("Hit map boundary");
              is_running = false;
          }
        }
    }
}
