package com.github.tckz916.lobbyescape.manager.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tckz916 on 2015/10/17.
 */
public class Double_Jump {

    private static List<Object> double_jump = new ArrayList<>();

    public static void add(Object object) {
        double_jump.add(object);
    }

    public static void remove(Object object) {
        double_jump.remove(object);
    }

    public static boolean contains(Object object) {
        return double_jump.contains(object);
    }

}
